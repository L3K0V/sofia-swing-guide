package bg.lindyhop.jobs;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import bg.lindyhop.controllers.GuideController;
import bg.lindyhop.entities.Guide;
import bg.lindyhop.events.FetchedGuideEvent;
import bg.lindyhop.models.GuideModel;
import de.greenrobot.event.EventBus;

/**
 * Created by lekov on 1/24/16.
 */
public class FetchGuideJob extends Job {

    public FetchGuideJob() {
        super(new Params(Priority.NORMAL).requireNetwork().groupBy("123"));
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        final GuideModel model = GuideModel.getInstance();
        final GuideController controller = GuideController.getInstance();
        final Guide item = controller.loadGuide();
        model.insertOrReplace(item);

        final EventBus bus = EventBus.getDefault();
        bus.post(new FetchedGuideEvent());
    }

    @Override
    protected void onCancel() {

    }
}

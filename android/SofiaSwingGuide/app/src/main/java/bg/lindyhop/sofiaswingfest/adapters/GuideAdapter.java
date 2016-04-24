package bg.lindyhop.sofiaswingfest.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import bg.lindyhop.entities.Guide;
import bg.lindyhop.sofiaswingfest.R;

/**
 * Created by lekov on 4/10/16.
 */
public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.ViewHolder> {

    private JSONArray guide;
    private final Activity mActivity;

    public  GuideAdapter(Activity activity, Guide guide) throws JSONException {
        this.mActivity = activity;
        this.guide = new JSONArray(guide.getGeo());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_list_item, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView text = (TextView) holder.itemView.findViewById(R.id.type);
        try {
            text.setText(guide.getJSONObject(position).getJSONObject("properties").getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return guide.length();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

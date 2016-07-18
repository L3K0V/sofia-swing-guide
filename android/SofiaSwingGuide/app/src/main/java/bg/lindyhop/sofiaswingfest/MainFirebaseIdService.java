package bg.lindyhop.sofiaswingfest;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import bg.lindyhop.entities.AuthToken;
import bg.lindyhop.network.AuthTokenService;
import bg.lindyhop.network.Config;
import bg.lindyhop.network.PushService;
import bg.lindyhop.network.ServiceGenerator;
import retrofit.ResponseCallback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lekov on 7/18/16.
 */
public class MainFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        final AuthTokenService tokenService = ServiceGenerator.createService(AuthTokenService.class, Config.CLIENT_ID, Config.CLIENT_SECRET);
        final AuthToken token = tokenService.obtainToken(Config.GRANT_TYPE);
        final PushService service = ServiceGenerator.createService(PushService.class, token);
        service.registerDevice(FirebaseInstanceId.getInstance().getId(), FirebaseInstanceId.getInstance().getToken(), true, new ResponseCallback() {
            @Override
            public void success(Response response) {
                /* ignored */
            }

            @Override
            public void failure(RetrofitError error) {
                /* ignored */
            }
        });
    }
}

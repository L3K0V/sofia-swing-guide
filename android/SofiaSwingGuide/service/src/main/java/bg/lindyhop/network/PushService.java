package bg.lindyhop.network;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by lekov on 7/18/16.
 */
public interface PushService {

    @FormUrlEncoded
    @POST("/device/gcm/")
    void registerDevice(@Field("name")String name, @Field("registration_id") String token, @Field("active") boolean active, Callback<Response> response);
}

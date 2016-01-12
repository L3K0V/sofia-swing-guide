package bg.lindyhop.network;

import bg.lindyhop.entities.AuthToken;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by mmironov on 1/12/16.
 */
public interface AuthTokenService {

    @POST("/oauth2/token/")
    AuthToken obtainToken(@Query("grant_type") String grantType);
}

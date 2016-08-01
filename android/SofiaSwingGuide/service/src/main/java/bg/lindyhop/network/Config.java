package bg.lindyhop.network;

import bg.lindyhop.BuildConfig;

/**
 * Created by mmironov on 12/23/15.
 */
public class Config {

    public static final String SERVER_URL = BuildConfig.API_URL;

    public static final String CLIENT_ID = BuildConfig.API_CLIENT_ID;
    public static final String CLIENT_SECRET = BuildConfig.API_CLIENT_SECRET;
    public static final String GRANT_TYPE = "client_credentials";
}

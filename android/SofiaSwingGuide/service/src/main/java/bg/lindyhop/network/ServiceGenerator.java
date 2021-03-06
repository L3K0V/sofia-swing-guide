package bg.lindyhop.network;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import bg.lindyhop.entities.AuthToken;
import bg.lindyhop.entities.Guide;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ServiceGenerator {

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Config.SERVER_URL);

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        if (username != null && password != null) {
            // concatenate username and password with colon for authentication
            String credentials = username + ":" + password;
            // create Base64 encodet string
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Authorization", basic);
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            });
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        RestAdapter adapter = builder.setConverter(new GsonConverter(gson)).build();
        return adapter.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final AuthToken token) {

        if (token != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    request.addHeader("Authorization",
                                    token.getTokenType() + " " + token.getAccess_token());
                }
            });
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        RestAdapter adapter = builder.setConverter(new GsonConverter(gson)).build();
        return adapter.create(serviceClass);
    }

    public static <S> S createServiceWithDeserializer(Class<S> serviceClass, final AuthToken token) {

        if (token != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    request.addHeader("Authorization",
                            token.getTokenType() + " " + token.getAccess_token());
                }
            });
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .registerTypeAdapter(Guide.class, new GEOJSONDeserializer())
                .create();

        RestAdapter adapter = builder.setConverter(new GsonConverter(gson)).build();
        return adapter.create(serviceClass);
    }

    public static class GEOJSONDeserializer implements JsonDeserializer<Guide> {

        @Override
        public Guide deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray features = json.getAsJsonObject().getAsJsonArray("features");
            String type = json.getAsJsonObject().get("type").getAsString();
            return new Guide(type, features.toString(), 1L);
        }
    }
}
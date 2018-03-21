package com.demo.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Base64;

/**
 * Created by alpa on 3/20/18
 */
public class RestClient {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";

    public static <T> T createService(Class<T> service, String schema, String host) {
        return getBuilder(getBaseUrl(schema, host))
                .client(getClient(null, null).build())
                .build()
                .create(service);
    }

    public static <T> T createService(Class<T> service, String schema, String host, String user, String password) {
        return getBuilder(getBaseUrl(schema, host))
                .client(getClient(user, password).build())
                .build()
                .create(service);
    }

    private static Retrofit.Builder getBuilder(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
    }

    private static OkHttpClient.Builder getClient(String user, String password) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));
        if (user != null && password != null) {
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                final String credentials = user + ":" + password;
                String headerValue = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
                Request.Builder requestBuilder = original.newBuilder()
                        .header(AUTHORIZATION_HEADER, headerValue)
                        .header(CONTENT_TYPE, APPLICATION_JSON);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
        }

        return httpClient;
    }


    private static String getBaseUrl(String schema, String host) {
        return String.format("%s://%s", schema, host);
    }
}

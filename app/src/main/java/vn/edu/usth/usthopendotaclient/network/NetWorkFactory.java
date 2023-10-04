package vn.edu.usth.usthopendotaclient.network;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;

public class NetWorkFactory {
    private static IApiService mApiBuilder;

    private static IApiService getAPIBuilder() {
        if (mApiBuilder == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.addInterceptor(chain -> {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder().build();
                        request = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(request);
                    })
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                    .addInterceptor(new CookieInterceptor())
//                    .addNetworkInterceptor(new StethoInterceptor())
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.opendota.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(builder.build())
                    .build();
            mApiBuilder = retrofit.create(IApiService.class);
        }
        return mApiBuilder;
    }

    public static Call<List<PlayerObj>> getProPlayer(){
        return getAPIBuilder().proPlayers();
    }
}

package vn.edu.usth.usthopendotaclient.Search.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.http.Path;
import vn.edu.usth.usthopendotaclient.Search.Model.profiles;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestUser {
    RequestUser requestUser = new Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RequestUser.class);;


}

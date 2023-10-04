package vn.edu.usth.usthopendotaclient.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.usth.usthopendotaclient.Search.Model.profiles;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;

public interface IApiService {
    @GET("/api/players/{account_id}")
    Call<profiles> getUser(@Path("account_id") int account_id);


    @GET("proPlayers")
    Call<List<PlayerObj>> proPlayers();


}

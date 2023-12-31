package vn.edu.usth.usthopendotaclient.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.ProPlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.PlayerWinLoss;
import vn.edu.usth.usthopendotaclient.network.models.RecentMatchesObj;

public interface IApiService {
    @GET("players/{account_id}")
    Call<PlayerObj> playerData(@Path("account_id") int account_id);

    @GET("proPlayers")
    Call<List<ProPlayerObj>> proPlayers();

    @GET("players/{account_id}/wl")
    Call<PlayerWinLoss> playerWinLoss(@Path("account_id") int account_id);

    @GET("players/{account_id}/recentMatches")
    Call<List<RecentMatchesObj>> recentMatcheObj(@Path("account_id") int account_id);


}

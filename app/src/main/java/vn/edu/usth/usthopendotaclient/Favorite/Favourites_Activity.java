package vn.edu.usth.usthopendotaclient.Favorite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.usthopendotaclient.MainActivity;
import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Search.SearchAdapter;
import vn.edu.usth.usthopendotaclient.Search.Search_Activity;
import vn.edu.usth.usthopendotaclient.Setting.SettingActivity;
import vn.edu.usth.usthopendotaclient.Search.profile.playerProfile_Activity;
import vn.edu.usth.usthopendotaclient.network.NetWorkFactory;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.PlayerWinLoss;
import vn.edu.usth.usthopendotaclient.network.models.ProPlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.RecentMatchesObj;
import vn.edu.usth.usthopendotaclient.utils.PrefUtil;

public class Favourites_Activity extends AppCompatActivity {
    private RelativeLayout relativeLayoutSearch;
    private SharedPreferences sharedPreferences;
    private int storedColor;
    private CardView cardViewItem;
    private ArrayList<ProPlayerObj> listFavorited;
    private RecyclerView recyclerView;
    private SearchAdapter favAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        relativeLayoutSearch = findViewById(R.id.relative_layout_favorite);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        relativeLayoutSearch.setBackgroundColor(storedColor);

        Toolbar toolbar = findViewById(R.id.favourites_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.fav_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_home){
//                    Toast toast = Toast.makeText(MainActivity.this, " Homw has been clicked", Toast.LENGTH_SHORT);
//                    toast.show();
                    Intent intent= new Intent(Favourites_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Intent intent= new Intent(Favourites_Activity.this, Favourites_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search){
                    Intent intent= new Intent(Favourites_Activity.this, Search_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting){
                    Intent intent = new Intent(Favourites_Activity.this, SettingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        recyclerView=findViewById(R.id.fav_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Favourites_Activity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        favAdapter = new SearchAdapter(Favourites_Activity.this, listFavorited, new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerObj user) {
                onClickGoTODetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {
            }

        });
        recyclerView.setAdapter(favAdapter);

        listFavorited = PrefUtil.getListFavorite(getSharedPreferences("shared", Context.MODE_PRIVATE));

    }

    @Override
    protected void onResume() {
        super.onResume();
        int updatedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        if (storedColor != updatedColor) {
            storedColor = updatedColor;
            relativeLayoutSearch.setBackgroundColor(storedColor);
        }
    }

    private void onClickGoTODetail(ProPlayerObj user) {
        NetWorkFactory.getRecentMatch(user.getAccountId()).enqueue(new Callback<List<RecentMatchesObj>>() {
            @Override
            public void onResponse(Call<List<RecentMatchesObj>> call, Response<List<RecentMatchesObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    callGetPlayerData(user,
                            response.body().subList(0, Math.min(response.body().size(), 30)));
                }
            }

            @Override
            public void onFailure(Call<List<RecentMatchesObj>> call, Throwable t) {
                Log.e("recent matches list", "onFailure: ", t);
            }
        });


    }

    private void callGetPlayerData(ProPlayerObj user, List<RecentMatchesObj> recentMatchesList) {
        NetWorkFactory.getPlayerData(user.getAccountId()).enqueue(new Callback<PlayerObj>() {
            @Override
            public void onResponse(Call<PlayerObj> call, Response<PlayerObj> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PlayerObj playerObj = response.body();
                    playerObj.setProfile(user);
                    callGetPlayerWl(playerObj, user.getAccountId(), recentMatchesList);
                }
            }

            @Override
            public void onFailure(Call<PlayerObj> call, Throwable t) {
                Log.e("player_data", "onFailure: ", t);
            }
        });
    }

    private void callGetPlayerWl(PlayerObj playerObj, int accountId, List<RecentMatchesObj> recentMatchesList) {

        NetWorkFactory.getPlayerWinLoss(accountId).enqueue(new Callback<PlayerWinLoss>() {
            @Override
            public void onResponse(Call<PlayerWinLoss> call, Response<PlayerWinLoss> response) {
                if (response.isSuccessful() && response.body() != null) {
                    playerObj.setWinLoss(response.body());
                    Intent intent = new Intent(Favourites_Activity.this, playerProfile_Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("player_data", playerObj);
                    bundle.putSerializable("player_recent_matches", new ArrayList<>(recentMatchesList));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PlayerWinLoss> call, Throwable t) {
                Log.e("recent matches list", "onFailure: ", t);
            }
        });
    }


}
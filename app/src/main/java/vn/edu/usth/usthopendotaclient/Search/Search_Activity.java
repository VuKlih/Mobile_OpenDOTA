package vn.edu.usth.usthopendotaclient.Search;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RelativeLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.usthopendotaclient.Favorite.Favourites_Activity;
import vn.edu.usth.usthopendotaclient.MainActivity;
import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Setting.SettingActivity;
import vn.edu.usth.usthopendotaclient.network.NetWorkFactory;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;

public class Search_Activity extends AppCompatActivity {

    private final String TAG = Search_Activity.class.getSimpleName();

    private RelativeLayout relativeLayoutSearch;
    private SharedPreferences sharedPreferences;
    SearchView searchView;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    ArrayList<PlayerObj> listPlayer;
    ArrayList<PlayerObj> arrayList;
    ArrayList<ModelClass> searchList;

    // to store background color
    private int storedColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        relativeLayoutSearch = findViewById(R.id.relative_layout_search);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        relativeLayoutSearch.setBackgroundColor(storedColor);

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Search_Activity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        searchView=findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.search_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // navigation
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
                    Intent intent= new Intent(Search_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Intent intent= new Intent(Search_Activity.this, Favourites_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search){
                    Intent intent= new Intent(Search_Activity.this, Search_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting){
                    Intent intent = new Intent(Search_Activity.this, SettingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        listPlayer = new ArrayList<>();
        arrayList = new ArrayList<>();
        searchAdapter = new SearchAdapter(Search_Activity.this, arrayList);
        recyclerView.setAdapter(searchAdapter);

        // search bar
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayList.clear();
                for(PlayerObj item: listPlayer){
                    if(item.getName().contains(newText)) {
                        arrayList.add(item);
                    }
                }
                searchAdapter.notifyDataSetChanged();
                return false;
            }
        });

        callGetProPlayer();
    }

    private void callGetProPlayer() {
        NetWorkFactory.getProPlayer().enqueue(new Callback<List<PlayerObj>>() {
            @Override
            public void onResponse(Call<List<PlayerObj>> call, Response<List<PlayerObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    listPlayer.clear();
                    listPlayer.addAll(response.body().subList(0, Math.min(response.body().size(), 20)));
                    arrayList.clear();
                    arrayList.addAll(response.body().subList(0, Math.min(response.body().size(), 20)));
                    searchAdapter.notifyDataSetChanged();
                }
                //TODO: remove bot giu lai 20 items
            }

            @Override
            public void onFailure(Call<List<PlayerObj>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
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
}



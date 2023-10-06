package vn.edu.usth.usthopendotaclient.Favorite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

import vn.edu.usth.usthopendotaclient.MainActivity;
import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Search.Search_Activity;
import vn.edu.usth.usthopendotaclient.Setting.SettingActivity;
import vn.edu.usth.usthopendotaclient.Search.profile.playerProfile_Activity;
import vn.edu.usth.usthopendotaclient.network.models.ProPlayerObj;
import vn.edu.usth.usthopendotaclient.utils.PrefUtil;

public class Favourites_Activity extends AppCompatActivity {
    private CardView cardViewItem;
    private ArrayList<ProPlayerObj> listFavorited;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

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




        listFavorited = PrefUtil.getListFavorite(getSharedPreferences("shared", Context.MODE_PRIVATE));

    }
}
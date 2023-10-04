package vn.edu.usth.usthopendotaclient.Search.profile;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import vn.edu.usth.usthopendotaclient.Search.ModelClass;
import vn.edu.usth.usthopendotaclient.R;

public class playerProfile_Activity extends AppCompatActivity {
    private TabLayout myTabLayout;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        myTabLayout = findViewById(R.id.pp_tabLayout);
        myViewPager = findViewById(R.id.viewPager);

        // get bundle which passed from search adapter
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        // get user contained in bundle by using key "object_player"
        ModelClass user = (ModelClass) bundle.get("object_player");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,user);
        myViewPager.setOffscreenPageLimit(3);
        myViewPager.setAdapter(viewPagerAdapter);
        myTabLayout.setupWithViewPager(myViewPager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
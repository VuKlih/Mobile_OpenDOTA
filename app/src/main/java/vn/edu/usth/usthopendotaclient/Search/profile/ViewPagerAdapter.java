package vn.edu.usth.usthopendotaclient.Search.profile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import vn.edu.usth.usthopendotaclient.Search.profile.matches.Matches_History_Fragment;
import vn.edu.usth.usthopendotaclient.Search.profile.overview.OverviewFragment;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.RecentMatchesObj;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String titles[]=new String[]{"Overview","Matches","Heroes"};
    PlayerObj user;
    ArrayList<RecentMatchesObj> recentMatchList;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, PlayerObj user,ArrayList<RecentMatchesObj> recentMatchList) {
        super(fm,behavior);
        this.user=user;
        this.recentMatchList= recentMatchList;
    }

    @NonNull
    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 1: return new Matches_History_Fragment();
            case 2: return new PlayerHeroesFragment();
            default: return new OverviewFragment(user,recentMatchList);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int page) {

        return titles[page];
    }
}



package vn.edu.usth.usthopendotaclient.Search.profile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.edu.usth.usthopendotaclient.Search.ModelClass;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String titles[]=new String[]{"Overview","Matches","Heroes"};
    ModelClass user;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, ModelClass user) {
        super(fm,behavior);
        this.user=user;
    }

    @NonNull
    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 1: return new Matches_History_Fragment();
            case 2: return new PlayerHeroesFragment();
            default: return new OverviewFragment(user);
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



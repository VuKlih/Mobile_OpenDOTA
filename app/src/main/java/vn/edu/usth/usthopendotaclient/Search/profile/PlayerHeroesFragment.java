package vn.edu.usth.usthopendotaclient.Search.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Search.profile.Hero_info;


public class PlayerHeroesFragment extends Fragment {
    private LinearLayout anti_mage;
    private LinearLayout invoker;
    private LinearLayout slark;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_player_heroes, container, false);



        return v;
    }


}
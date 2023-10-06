package vn.edu.usth.usthopendotaclient.Search.profile.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import vn.edu.usth.usthopendotaclient.MainActivity;
import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.network.models.RecentMatchesObj;

public class Matches_History_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<RecentMatchesObj> listRecentMatches;

    public Matches_History_Fragment(ArrayList<RecentMatchesObj> listRecentMatches){
        this.listRecentMatches=listRecentMatches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_matches_history, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.matches_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchesAdapter MatchesAdapter = new MatchesAdapter(getContext(), listRecentMatches);
        recyclerView.setAdapter(MatchesAdapter);
        MatchesAdapter.notifyDataSetChanged();

    }
}


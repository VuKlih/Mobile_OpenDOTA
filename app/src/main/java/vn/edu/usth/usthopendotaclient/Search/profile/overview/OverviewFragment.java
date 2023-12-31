package vn.edu.usth.usthopendotaclient.Search.profile.overview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Search.SearchAdapter;
import vn.edu.usth.usthopendotaclient.Search.Search_Activity;
import vn.edu.usth.usthopendotaclient.Search.profile.matches.MatchesAdapter;
import vn.edu.usth.usthopendotaclient.network.NetWorkFactory;
import vn.edu.usth.usthopendotaclient.network.models.MatchesObj;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.PlayerWinLoss;
import vn.edu.usth.usthopendotaclient.network.models.ProPlayerObj;
import vn.edu.usth.usthopendotaclient.network.models.RecentMatchesObj;


public class OverviewFragment extends Fragment {
    TextView player_name;
    TextView player_steam;
    TextView tvWin;
    TextView tvLose;
    TextView winrate;
    ProgressBar progressBar;
    ImageView player_avatar;
    TextView player_win, player_loose,player_winrate;
    PlayerObj user;
    RecentMatchesObj recentMatches;
    private RecentMatchesAdapter RecentMatchesAdapter;
    private RecyclerView recyclerView;
    private ArrayList<RecentMatchesObj> listRecentMatches;


    public OverviewFragment(PlayerObj user, ArrayList<RecentMatchesObj> listRecentMatches) {
        this.user = user;
        this.listRecentMatches=listRecentMatches;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_overview, container, false);

        player_name = view.findViewById(R.id.A_name);
        player_avatar= view.findViewById(R.id.A_image);
        player_steam = view.findViewById(R.id.profile_steam);
        tvWin = view.findViewById(R.id.tv_win);
        tvLose = view.findViewById(R.id.losses);
        winrate = view.findViewById(R.id.winrate);
        progressBar = view.findViewById(R.id.progressBar);


        player_name.setText(user.getProfile().getName());
        Picasso.get().load(user.getProfile().getAvatarmedium()).into(player_avatar);
        player_steam.setText(user.getProfile().getProfileurl());

        int w = user.getWinLoss().getWin();
        int l = user.getWinLoss().getLose();
        int rate = (w * 100) / (w + l);

        tvWin.setText("WINS\n" + w);
        tvLose.setText("LOSSES\n" + l);
        winrate.setText("WINRATE\n" + rate + "%");
        progressBar.setProgress(rate);

        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.rm_recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchesAdapter MatchesAdapter = new MatchesAdapter(getContext(), listRecentMatches);
        recyclerView.setAdapter(MatchesAdapter);
        MatchesAdapter.notifyDataSetChanged();
    }
}

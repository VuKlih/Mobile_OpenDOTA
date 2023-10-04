package vn.edu.usth.usthopendotaclient.Search.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.usth.usthopendotaclient.Search.ModelClass;
import vn.edu.usth.usthopendotaclient.R;


public class OverviewFragment extends Fragment {
    TextView player_name;
    ImageView player_avatar;
    TextView player_win, player_loose,player_winrate;
    ModelClass user;

    public OverviewFragment(ModelClass user) {
        this.user = user;
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
        player_name.setText(user.getUserName());

        player_avatar= view.findViewById(R.id.A_image);
        player_avatar.setImageResource(user.getImg());

        player_win = view.findViewById(R.id.wins);
        player_loose = view.findViewById(R.id.losses);
        player_win.setText("WINS\n" + user.getUserWin());
        player_loose.setText("LOOSES\n"+ user.getUserLose());

//        player_winrate=view.findViewById(R.id.winrate);
//        player_winrate.setText("WINRATE\n"+ user.getUserWinrate(user.getUserWin(),user.getUserLose()));
        return  view;
    }
}

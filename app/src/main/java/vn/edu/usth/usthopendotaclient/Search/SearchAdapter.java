package vn.edu.usth.usthopendotaclient.Search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.usth.usthopendotaclient.R;
import vn.edu.usth.usthopendotaclient.Search.profile.playerProfile_Activity;
import vn.edu.usth.usthopendotaclient.network.models.PlayerObj;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder>{
    private Context context;
    private ArrayList<PlayerObj> arrayListUser;

    public SearchAdapter(Context context, ArrayList<PlayerObj> arrayListUser){
        this.context = context;
        this.arrayListUser = arrayListUser;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file,parent,false);
        return new MyHolder(view);
    }

    @Override
    // bind data len list
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final PlayerObj user = arrayListUser.get(position);
        if(user == null){
            return;
        }
        holder.userName.setText(user.getName());
        holder.userID.setText(String.valueOf(user.getAccountId()));
        Picasso.get().load(user.getAvatarmedium()).into(holder.imgAvatar);
        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoTODetail(null);
            }
        });
    }

    private void onClickGoTODetail(ModelClass user){
        Intent intent = new Intent(context, playerProfile_Activity.class );
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_player", user);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (arrayListUser != null){
            return arrayListUser.size();
        }
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private CardView cardViewItem;
        private ImageView imgAvatar;
        private TextView userName;
        private TextView userID;

        public MyHolder(@NonNull View itemView) { // khai bao thanh phan co trong item_file
            super(itemView);
            cardViewItem = itemView.findViewById(R.id.layout_item_file);
            userName=itemView.findViewById(R.id.name);
            userID=itemView.findViewById(R.id.ID);
            imgAvatar=itemView.findViewById(R.id.img);
        }
    }
}

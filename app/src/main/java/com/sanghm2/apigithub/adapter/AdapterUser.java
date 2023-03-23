package com.sanghm2.apigithub.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.model.SearchUser;
import com.sanghm2.apigithub.screen.HomeScreen;
import com.sanghm2.apigithub.screen.ListRepositoryScreen;
import com.sanghm2.apigithub.screen.ListUserScreen;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyHolder>{
    Context context ;
    List<SearchUser> searchUserList ;

    public AdapterUser(Context context, List<SearchUser> searchUserList) {
        this.context = context;
        this.searchUserList = searchUserList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_search_user , parent, false);
        return new MyHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SearchUser item = searchUserList.get(position);
        Glide.with(context).load(item.getAvatarURL()).placeholder(R.drawable.error).into(holder.avatar);
        holder.nameGithub.setText(item.getLogin());
        holder.type.setText(item.getType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListRepositoryScreen.class);
                intent.putExtra("name",item.getLogin());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchUserList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ShapeableImageView avatar ;
        TextView nameGithub ,type;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
           avatar = itemView.findViewById(R.id.avatar);
           nameGithub = itemView.findViewById(R.id.nameGithub);
           type = itemView.findViewById(R.id.type);
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateAdapter(List<SearchUser> searchUserList){
        this.searchUserList = searchUserList ;
        notifyDataSetChanged();
    }
}

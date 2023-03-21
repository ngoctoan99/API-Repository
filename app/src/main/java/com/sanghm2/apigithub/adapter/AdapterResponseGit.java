package com.sanghm2.apigithub.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.model.Item;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

public class AdapterResponseGit extends RecyclerView.Adapter<AdapterResponseGit.MyHolder>{
        Context context ;
        List<Item> itemList ;

    public AdapterResponseGit(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_response_git , parent, false);
        return new MyHolder(view) ;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Item item = itemList.get(position);
        /// get Name repo
        holder.name.setText(item.getName());

        /// covert date to long and long to date dd-mm-yyyy
        String dateString = item.getCreatedAt() ;
        Instant instant = Instant.parse(dateString);
        long millis = instant.toEpochMilli();
        Date date = new Date(millis);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateString1 = sdf.format(date);
        holder.createdAt.setText(dateString1);

//        /// check private item card
        if(item.getItemPrivate()){
            holder.privateCard.setText("Private");
            holder.cardGround.setBackgroundResource(R.color.red);
        }else {
            holder.privateCard.setText("Public");
            holder.cardGround.setBackgroundResource(R.color.green);
        }

        /// language code
        if(item.getLanguage() == null ||  item.getLanguage().isEmpty()){
            holder.language.setText("Unknown");
        }else {
            holder.language.setText(item.getLanguage());
        }

        //size of repo
        long kb = item.getSize() ;
        long mb = kb / 1024 ;
        if(mb > 1){
            holder.size.setText("" + mb + " Mb");
        }else {
            holder.size.setText("" + kb + " Kb");
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name , language, size, createdAt ,privateCard;
        MaterialCardView cardGround;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            language = itemView.findViewById(R.id.language);
            size = itemView.findViewById(R.id.size);
            createdAt = itemView.findViewById(R.id.createdAt);
            privateCard = itemView.findViewById(R.id.privateCard);
            cardGround = itemView.findViewById(R.id.cardGround);
        }
    }
}
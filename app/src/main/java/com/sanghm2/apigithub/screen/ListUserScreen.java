package com.sanghm2.apigithub.screen;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.adapter.AdapterResponseGit;
import com.sanghm2.apigithub.adapter.AdapterUser;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.model.SearchUser;
import com.sanghm2.apigithub.model.User;
import com.sanghm2.apigithub.retrofit.RetrofitAPI;
import com.sanghm2.apigithub.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserScreen extends AppCompatActivity {

    List<SearchUser> searchUserList ;
    AdapterUser adapterUser ;
    TextView nameSearchTv ;
    String namesearch ;
    RelativeLayout rlLoading;
    RecyclerView rvUser ;
    int page = 1 ;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_screen);
        namesearch = getIntent().getStringExtra("namesearch");
        initView();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        callApiSearch(namesearch,page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        searchUserList = new ArrayList<>();
        rvUser = findViewById(R.id.rv_user);
        nameSearchTv = findViewById(R.id.nameSearch);
        nameSearchTv.setText(namesearch);
        rlLoading = findViewById(R.id.rlLoading) ;
        adapterUser  = new AdapterUser(getApplicationContext() , searchUserList);
        rvUser.setAdapter(adapterUser);
        rvUser.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(!view.canScrollVertically(1)){
                    callApiSearch(namesearch,page);
                }
            }
        });
    }

    private void callApiSearch(String name,int pages){
       if(pages == 1){
           rlLoading.setVisibility(View.VISIBLE);
           rvUser.setVisibility(View.GONE);
       }
        RetrofitConfig.getClient().create(RetrofitAPI.class).getSearchUser(name,pages,10,"stars","desc").enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    List<SearchUser>searchUserLists  = SearchUser.FromJson(response.body().toString());
                    searchUserList.addAll(searchUserLists);
                    adapterUser.updateAdapter(searchUserList);
                    page++ ;
                    if(pages == 1){
                        rlLoading.setVisibility(View.GONE);
                        rvUser.setVisibility(View.VISIBLE);
                    }
                }
            }
            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

}
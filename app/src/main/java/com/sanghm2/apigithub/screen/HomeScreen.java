package com.sanghm2.apigithub.screen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.gson.JsonElement;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.adapter.AdapterResponseGit;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.retrofit.RetrofitAPI;
import com.sanghm2.apigithub.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity {
    EditText searchName;
    List<Item> itemList ;
    RecyclerView rv_new_repo ;
    ImageButton searchBtn ;
    RelativeLayout rlLoading ;
    AdapterResponseGit adapterResponseGit ;
    SwipeRefreshLayout refresh ;
    int page = 1;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initView();
        getNewRepo(page);
        actionSearch();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void actionSearch() {
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,ListUserScreen.class);
                intent.putExtra("namesearch",searchName.getText().toString().trim());
                startActivity(intent);
                searchName.setText("");
                hideKeyBoard();
            }
        });
        rv_new_repo.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(!view.canScrollVertically(1)){
                    page++;
                    getNewRepo(page);
                }
            }
        });
    }


    private void getNewRepo(int page) {
        if(page ==1){
            rlLoading.setVisibility(View.VISIBLE);
            rv_new_repo.setVisibility(View.GONE);
        }
        RetrofitConfig.getClient().create(RetrofitAPI.class).getRepoNew(page,10,"stars","desc").enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    List<Item> itemLists  = Item.FromJson(response.body().toString());
                    itemList.addAll(itemLists) ;
                    adapterResponseGit.updateAdapter(itemList);
                    if(page ==1){
                        rlLoading.setVisibility(View.GONE);
                        rv_new_repo.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }

    private void initView() {
        searchName  = findViewById(R.id.searchName);
        itemList = new ArrayList<>() ;
        rv_new_repo = findViewById(R.id.rv_new_repo);
        searchBtn = findViewById(R.id.searchBtn);
        rlLoading = findViewById(R.id.rlLoading);
        refresh = findViewById(R.id.refresh);
        adapterResponseGit  = new AdapterResponseGit(getApplicationContext() , itemList);
        rv_new_repo.setAdapter(adapterResponseGit);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page =1 ;
                getNewRepo(page);
                rv_new_repo.scrollToPosition(0);
                refresh.setRefreshing(false);
            }
        });
    }
    private void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
package com.sanghm2.apigithub.screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.adapter.AdapterResponseGit;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.model.Test;
import com.sanghm2.apigithub.retrofit.RetrofitAPI;
import com.sanghm2.apigithub.retrofit.RetrofitConfig;

import java.io.DataInput;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRepositoryScreen extends AppCompatActivity {
    List<Item> listItem ;
    RecyclerView recyclerView ;
    RelativeLayout rlLoading , errorRl;
    TextView errorText ;
    String name = "" ;
    AdapterResponseGit adapterResponseGit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getIntent().getStringExtra("name");
        initView();
        callApi(name);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView_git);
        listItem =  new ArrayList<>();
        rlLoading = findViewById(R.id.rlLoading);
        errorRl = findViewById(R.id.errorRl);
        errorText = findViewById(R.id.errorText);

    }
    private void callApi(String name) {
        listItem.clear();
        rlLoading.setVisibility(View.VISIBLE);
        RetrofitConfig.getClient().create(RetrofitAPI.class).getAllRepo(name).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(@NonNull Call<JsonElement> call, @NonNull Response<JsonElement> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    String json = response.body().toString();
                    listItem = new Gson().fromJson(json,  new TypeToken<ArrayList<Item>>(){}.getType());
                    adapterResponseGit  = new AdapterResponseGit(getApplicationContext() , listItem);
                    recyclerView.setAdapter(adapterResponseGit);
                    rlLoading.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else {
                    rlLoading.setVisibility(View.GONE);
                    errorRl.setVisibility(View.VISIBLE);
                    assert response.errorBody() != null;
                    errorText.setText(response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(@NonNull Call<JsonElement> call, Throwable t) {
                rlLoading.setVisibility(View.GONE);
                errorRl.setVisibility(View.VISIBLE);
                errorText.setText(t.getMessage());
            }
        });
    }
}
package com.sanghm2.apigithub.screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.adapter.AdapterResponseGit;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.model.User;
import com.sanghm2.apigithub.retrofit.RetrofitAPI;
import com.sanghm2.apigithub.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRepositoryScreen extends AppCompatActivity {
    List<Item> listItem ;
    RecyclerView recyclerView ;
    RelativeLayout rlLoading , errorRl;
    TextView errorText ;
    String name = "" ;
    ImageView shareBtn ;
    ShapeableImageView avatar ;
    TextView fullName ,nameGithub , bio ;
    AdapterResponseGit adapterResponseGit ;
    User user ;
    String url  ;
    SwipeRefreshLayout refresh ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repository_screen);
        name = getIntent().getStringExtra("name");
        initView();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        callApi(name);
        setData();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setData() {
        RetrofitConfig.getClient().create(RetrofitAPI.class).getUser(name).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    String json = response.body().toString();
                    user  = new Gson().fromJson(json,  new TypeToken<User>(){}.getType());
                    if (user.getName() == null || user.getName().isEmpty()){
                        fullName.setText("Unknown");
                    }else {
                        fullName.setText(user.getName());
                    }
                    nameGithub.setText(user.getLogin());
                    bio.setText(user.getBio());
                    url = user.getAvatarURL() ;
                    Glide.with(getApplicationContext()).load(user.getAvatarURL()).placeholder(R.drawable.error).into(avatar);
                }

            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView_git);
        listItem =  new ArrayList<>();
        rlLoading = findViewById(R.id.rlLoading);
        errorRl = findViewById(R.id.errorRl);
        errorText = findViewById(R.id.errorText);
        avatar = findViewById(R.id.avatar);
        refresh = findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callApi(name);
                setData();
                refresh.setRefreshing(false);
            }
        });
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListRepositoryScreen.this, FullmageScreen.class);
                intent.putExtra("image",url);
                startActivity(intent);
            }
        });
        fullName = findViewById(R.id.fullName);
        nameGithub = findViewById(R.id.nameGithub);
        bio = findViewById(R.id.bio);
        shareBtn = findViewById(R.id.shareBtn) ;
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
//                    String shareMessage= "\nLet me recommend you this application\n\n";
//                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    String shareMessage = user.getHTMLURL();
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });
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
    @Override


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
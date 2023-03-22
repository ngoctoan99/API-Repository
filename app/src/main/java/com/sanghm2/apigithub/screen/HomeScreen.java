package com.sanghm2.apigithub.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sanghm2.apigithub.R;
import com.sanghm2.apigithub.adapter.AdapterResponseGit;
import com.sanghm2.apigithub.model.Item;
import com.sanghm2.apigithub.retrofit.RetrofitAPI;
import com.sanghm2.apigithub.retrofit.RetrofitConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity {
    EditText searchName;
    List<Item> itemList ;
    RecyclerView rv_new_repo ;
    AdapterResponseGit adapterResponseGit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_repo_by_name);
        initView();
        getNewRepo();
    }

    private void getNewRepo() {
        itemList.clear();
        RetrofitConfig.getClient().create(RetrofitAPI.class).getRepoNew().enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
//                    try {
//                        String json = response.body().toString();
//                        JSONObject jsonObject = new JSONObject(json);
//                        itemList = new Gson().fromJson(jsonObject.getString("items"),  new TypeToken<ArrayList<Item>>(){}.getType());
//                    } catch (JSONException jse) {
//                        jse.printStackTrace();
//                    }
                    itemList  = Item.FromJson(response.body().toString());
                    adapterResponseGit  = new AdapterResponseGit(getApplicationContext() , itemList);
                    rv_new_repo.setAdapter(adapterResponseGit);
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

    }
    private void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
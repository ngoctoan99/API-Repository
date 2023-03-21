package com.sanghm2.apigithub.retrofit;

import com.google.gson.JsonElement;
import com.sanghm2.apigithub.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("/posts")
    Call<JsonElement> getAllRepos();
    @GET("/users/{user}/repos")
    Call<JsonElement>getAllRepo(@Path("user") String user);
}

package com.sanghm2.apigithub.retrofit;

import com.google.gson.JsonElement;
import com.sanghm2.apigithub.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("/users/{user}/repos")
    Call<JsonElement>getAllRepo(@Path("user") String user);

    @GET("/search/users?q={name}")
    Call<JsonElement>getUserByName(@Path("name") String name);

    @GET("/search/repositories?q={repo}")
    Call<JsonElement>getRepoByKey(@Path("repo") String repo);

    @GET("/users/{user}")
    Call<JsonElement>getUser(@Path("user") String user);

    @GET("/search/repositories?q=android&page=1&per_page=10&sort=stars&order=desc")
    Call<JsonElement>getRepoNew();
}

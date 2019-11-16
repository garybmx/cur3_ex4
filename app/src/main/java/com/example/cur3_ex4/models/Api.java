package com.example.cur3_ex4.models;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

        @GET("/users/{user}/repos")
        Call<List<Repos>> loadRepos(@Path("user") String user);

}

package com.example.cur3_ex4.models;
import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

        @GET("/users/{user}/repos")
        Single<List<Repos>> loadRepos(@Path("user") String user);

}

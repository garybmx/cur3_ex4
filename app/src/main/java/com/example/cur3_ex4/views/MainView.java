package com.example.cur3_ex4.views;

import com.example.cur3_ex4.models.Repos;

import java.util.List;

public interface MainView {
    void showRepos(List<Repos> repos);

    void showLoading();

    void showEmpty();
}

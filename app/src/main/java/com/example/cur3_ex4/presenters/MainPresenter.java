package com.example.cur3_ex4.presenters;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;


import com.example.cur3_ex4.NetworkService;
import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.views.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<List<Repos>, MainView> {
    private boolean isLoadingData = false;

    @Override
    protected void updateView() {
        // Business logic is in the presenter
        if (model.size() == 0) {
            view().showEmpty();
        } else {
            view().showRepos(model);
        }
    }

    @Override
    public void bindView(@NonNull MainView view) {
        super.bindView(view);

        // Let's not reload data if it's already here
        if (model == null && !isLoadingData) {
            view().showLoading();
            loadData();
        }
    }

    private void loadData() {
        isLoadingData = true;
        NetworkService.getInstance()
                .getJSONApi()
                .loadRepos("garybmx")
                .enqueue(new Callback<List<Repos>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Repos>> call, @NonNull Response<List<Repos>> response) {
                        List<Repos> reposes = response.body();
                        setModel(reposes);
                        isLoadingData = false;
                    }

                    @Override
                    public void onFailure(Call<List<Repos>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }

}

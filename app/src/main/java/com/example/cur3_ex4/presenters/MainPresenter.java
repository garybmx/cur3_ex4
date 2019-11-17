package com.example.cur3_ex4.presenters;

import android.content.Context;
import android.os.AsyncTask;

import android.os.Build;
import android.util.Log;


import com.example.cur3_ex4.NetworkService;
import com.example.cur3_ex4.db.AppDatabase;
import com.example.cur3_ex4.db.DbProvider;
import com.example.cur3_ex4.db.RoomDbImpl;
import com.example.cur3_ex4.models.Api;
import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.models.ReposRoomData;
import com.example.cur3_ex4.views.MainView;

import java.util.List;

import androidx.annotation.NonNull;

import io.reactivex.Single;

import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter extends BasePresenter<List<Repos>, MainView> {
    DbProvider<ReposRoomData, List<Repos>> dbRoom;

    public MainPresenter(Context context){
        dbRoom = new RoomDbImpl(AppDatabase.getInstance(context));
    }

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
            loadDataFromDB();
        }
    }

    public void loadDataToDB() {

        getDataFromInternet().subscribeOn(Schedulers.io()).doOnTerminate(() -> updateView()).subscribe(new DisposableSingleObserver<List<Repos>>() {
            @Override
            public void onSuccess(List<Repos> repos) {
                for (Repos item: repos) {
                    dbRoom.insert(ReposRoomData.convertToRoomData(item));
                }
                model = repos;
                isLoadingData = false;
            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }

    private void loadDataFromDB(){
        getDataFromDB().subscribeOn(Schedulers.io()).subscribe(new DisposableSingleObserver<List<Repos>>() {
            @Override
            public void onSuccess(List<Repos> repos) {
                setModel(repos);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


    public Single<List<Repos>> getDataFromDB() {
        return Single.fromCallable(() -> dbRoom.select()).subscribeOn(Schedulers.io());



    }

    public Single<List<Repos>>getDataFromInternet() {
        return NetworkService.getInstance()
                .getJSONApi()
                .loadRepos("garybmx").subscribeOn(Schedulers.io());
    }
}

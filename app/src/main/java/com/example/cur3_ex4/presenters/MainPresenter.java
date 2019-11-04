package com.example.cur3_ex4.presenters;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.annotation.NonNull;


import com.example.cur3_ex4.CounterDatabase;
import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.views.MainView;

import java.util.List;

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
        new LoadDataTask().execute();
    }


    // It's OK for this class not to be static and to keep a reference to the Presenter, as this
    // is retained during orientation changes and is lightweight (has no activity/view reference)
    private class LoadDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
           return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setModel(CounterDatabase.getInstance().getAllCounters());
            isLoadingData = false;
        }
    }
}

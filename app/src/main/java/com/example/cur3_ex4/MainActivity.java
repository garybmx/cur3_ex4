package com.example.cur3_ex4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.cur3_ex4.db.AppDatabase;
import com.example.cur3_ex4.db.DbProvider;
import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.models.ReposRoomData;
import com.example.cur3_ex4.presenters.MainPresenter;
import com.example.cur3_ex4.views.MainView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView mRecyclerView;
    private Button mReloadButton;
    private myAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            presenter = new MainPresenter(this);
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        mReloadButton = findViewById(R.id.reload);
        mReloadButton.setOnClickListener((View v) -> reloadClick());
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new myAdapter();
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bindView(this);
    }



    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbindView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }


    @Override
    public void showRepos(List<Repos> repos) {
        Log.i("up", "update!!");
        mAdapter.clearAndAddAll(repos);

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    private void reloadClick(){
        presenter.loadDataToDB();
    }
}

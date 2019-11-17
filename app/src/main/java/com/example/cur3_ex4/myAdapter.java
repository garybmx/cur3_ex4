package com.example.cur3_ex4;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.presenters.ReposPresenter;
import com.example.cur3_ex4.views.ReposViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class myAdapter extends MvpRecyclerListAdapter<Repos, ReposPresenter, ReposViewHolder> {

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReposViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false));
    }

    @NonNull
    @Override
    protected ReposPresenter createPresenter(@NonNull Repos repos) {
        ReposPresenter presenter = new ReposPresenter();
        presenter.setModel(repos);
        return presenter;
    }

    @NonNull
    @Override
    protected Object getModelId(@NonNull Repos model) {
        return model.getId();
    }

}



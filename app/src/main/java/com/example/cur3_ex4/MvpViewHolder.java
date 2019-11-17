package com.example.cur3_ex4;


import android.view.View;

import com.example.cur3_ex4.presenters.BasePresenter;

import androidx.recyclerview.widget.RecyclerView;

public abstract class MvpViewHolder<P extends BasePresenter> extends RecyclerView.ViewHolder {
    protected P presenter;

    public MvpViewHolder(View itemView) {
        super(itemView);
    }

    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.bindView(this);
    }

    public void unbindPresenter() {
        presenter = null;
    }
}

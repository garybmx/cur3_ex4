package com.example.cur3_ex4.views;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.cur3_ex4.MvpViewHolder;
import com.example.cur3_ex4.R;
import com.example.cur3_ex4.presenters.ReposPresenter;


public class ReposViewHolder extends MvpViewHolder<ReposPresenter> implements ReposView {


    private CardView cv;
    private TextView text;


    public ReposViewHolder(View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.card_view);
        text = (TextView)itemView.findViewById(R.id.cvElement);

    }

    @Override
    public void setReposName(String name) {
        text.setText(name);
    }

}

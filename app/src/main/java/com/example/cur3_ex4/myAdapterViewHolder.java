package com.example.cur3_ex4;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cur3_ex4.views.ReposView;

public class myAdapterViewHolder extends RecyclerView.ViewHolder implements ReposView {

    private CardView cv;
    private TextView text;


    myAdapterViewHolder(View itemView) {
        super(itemView);
        cv = (CardView)itemView.findViewById(R.id.card_view);
        text = (TextView)itemView.findViewById(R.id.cvElement);

    }

    @Override
    public void setReposName(String name) {
        text.setText(name);
    }
}

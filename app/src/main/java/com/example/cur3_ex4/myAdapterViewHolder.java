package com.example.cur3_ex4;


import android.view.View;
import android.widget.TextView;

import com.example.cur3_ex4.views.ReposView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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

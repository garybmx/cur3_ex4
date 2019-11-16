package com.example.cur3_ex4.presenters;

import com.example.cur3_ex4.models.Repos;
import com.example.cur3_ex4.views.ReposView;

public class ReposPresenter extends BasePresenter<Repos, ReposView> {
    @Override
    protected void updateView() {
            view().setReposName(model.getName());
    }
}

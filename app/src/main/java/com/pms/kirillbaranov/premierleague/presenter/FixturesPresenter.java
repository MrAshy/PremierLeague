package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.model.FixturesModel;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.view.IFixturesView;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesPresenter {

    private IFixturesView mFixturesView;
    private FixturesModel mFixturesModel;

    private RequestTask.IProgressBehavior mUpdateProgressBehaviour;

    public FixturesPresenter(IFixturesView view, RequestTask.IProgressBehavior updateProgressBehaviour) {
        mFixturesView = view;
        mFixturesModel = new FixturesModel();
        mUpdateProgressBehaviour = updateProgressBehaviour;
    }

    public void getCurrentFixtures() {
        ((Activity) mFixturesView).runOnUiThread(new RequestTask<Collection<Fixture>>(mUpdateProgressBehaviour) {
            @Override
            protected Collection<Fixture> doInBackground(Void... params) throws Exception {
                return mFixturesModel.getFixtures();
            }

            @Override
            protected void onSuccess(Collection<Fixture> fixtures) {
                mFixturesView.setContent(fixtures);
            }
        });
    }



}

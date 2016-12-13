package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
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


    public FixturesPresenter(IFixturesView view) {
        mFixturesView = view;
        mFixturesModel = new FixturesModel();
    }

    public void getCurrentFixtures(boolean refreshView) {
        Activity activity = (Activity) mFixturesView;

        if (activity != null) activity.runOnUiThread(new RequestTask<ResponseWrapper>(new RequestTask.IProgressBehavior() {
            @Override
            public void startTask() {
                mFixturesView.startUpdating(refreshView);
            }

            @Override
            public void endTask() {
                mFixturesView.endUpdating();
            }
        }) {
            @Override
            protected ResponseWrapper doInBackground(Void... params) throws Exception {
                return mFixturesModel.getFixtures();
            }

            @Override
            protected void onSuccess(ResponseWrapper responseWrapper) {
                mFixturesView.setContent(responseWrapper, refreshView);
            }
        });
    }



}

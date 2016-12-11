package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.Team;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
import com.pms.kirillbaranov.premierleague.model.TeamsModel;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.view.ITeamsView;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsPresenter {

    private ITeamsView mTeamsView;
    private TeamsModel mTeamsModel;

    private RequestTask.IProgressBehavior mUpdateProgressBehaviour;

    public TeamsPresenter(ITeamsView view, RequestTask.IProgressBehavior updateProgressBehaviour) {
        mTeamsView = view;
        mTeamsModel = new TeamsModel();
        mUpdateProgressBehaviour = updateProgressBehaviour;
    }

    public void getCurrentTeams() {
        ((Activity) mTeamsView).runOnUiThread(new RequestTask<ResponseWrapper>(mUpdateProgressBehaviour) {
            @Override
            protected ResponseWrapper doInBackground(Void... params) throws Exception {
                return mTeamsModel.getTeams();
            }

            @Override
            protected void onSuccess(ResponseWrapper responseWrapper) {
                mTeamsView.setContent(responseWrapper);
            }
        });
    }


}

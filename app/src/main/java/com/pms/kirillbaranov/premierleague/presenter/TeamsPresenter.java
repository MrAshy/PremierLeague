package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.Team;
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
        ((Activity) mTeamsView).runOnUiThread(new RequestTask<Collection<Team>>(mUpdateProgressBehaviour) {
            @Override
            protected Collection<Team> doInBackground(Void... params) throws Exception {
                return mTeamsModel.readTeams();
            }

            @Override
            protected void onSuccess(Collection<Team> teams) {
                mTeamsView.setContent(teams);
            }
        });
    }


}

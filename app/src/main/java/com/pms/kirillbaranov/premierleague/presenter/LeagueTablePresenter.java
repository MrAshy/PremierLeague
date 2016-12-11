package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.LeagueTable;
import com.pms.kirillbaranov.premierleague.model.TableLeagueModel;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.view.ITableLeagueView;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by KirillBaranov on 09.12.16.
 */

public class LeagueTablePresenter {

    private ITableLeagueView mTableLeagueView;
    private TableLeagueModel mTableLeagueModel;

    private RequestTask.IProgressBehavior mUpdateProgressBehaviour;

    public LeagueTablePresenter(ITableLeagueView view, RequestTask.IProgressBehavior updateProgressBehavior) {
        mTableLeagueView = view;
        mTableLeagueModel = new TableLeagueModel();
        mUpdateProgressBehaviour = updateProgressBehavior;
    }

    public void getCurrentLeagueTable() {
        ((Activity) mTableLeagueView).runOnUiThread(new RequestTask<LeagueTable>(mUpdateProgressBehaviour) {
            @Override
            protected LeagueTable doInBackground(Void... params) throws Exception {
                return mTableLeagueModel.getLeagueTable();
            }

            @Override
            protected void onSuccess(LeagueTable leagueTable) {
                mTableLeagueView.setContent(leagueTable);
            }
        });
    }
}

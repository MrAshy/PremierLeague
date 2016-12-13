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

    public LeagueTablePresenter(ITableLeagueView view) {
        mTableLeagueView = view;
        mTableLeagueModel = new TableLeagueModel();
    }

    public void getCurrentLeagueTable(boolean refreshView) {

        Activity activity = (Activity) mTableLeagueView;
        if (activity != null) activity.runOnUiThread(new RequestTask<LeagueTable>(new RequestTask.IProgressBehavior() {

        @Override
        public void startTask() {
            mTableLeagueView.startUpdating(refreshView);
        }

        @Override
        public void endTask() {
            mTableLeagueView.endUpdating();
        }
    })
        {
            @Override
            protected LeagueTable doInBackground(Void... params) throws Exception {
                return mTableLeagueModel.getLeagueTable();
            }

            @Override
            protected void onSuccess(LeagueTable leagueTable) {
                mTableLeagueView.setContent(leagueTable, refreshView);
            }
        });
    }
}

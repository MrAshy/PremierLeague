package com.pms.kirillbaranov.premierleague.presenter;

import android.app.Activity;

import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
import com.pms.kirillbaranov.premierleague.model.PlayersModel;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.view.IPlayersView;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersPresenter {

    private IPlayersView mPlayersView;
    private PlayersModel mPlayersModel;

    private RequestTask.IProgressBehavior mUpdateProgressBehaviour;

    public PlayersPresenter(IPlayersView view, RequestTask.IProgressBehavior updateProgressBehaviour) {
        mPlayersView = view;
        mPlayersModel = new PlayersModel();
        mUpdateProgressBehaviour = updateProgressBehaviour;
    }

    public void getCurrentPlayers(String playersURL) {
        ((Activity) mPlayersView).runOnUiThread(new RequestTask<ResponseWrapper>(mUpdateProgressBehaviour) {
            @Override
            protected ResponseWrapper doInBackground(Void... params) throws Exception {
                return mPlayersModel.getPlayers(playersURL);
            }

            @Override
            protected void onSuccess(ResponseWrapper responseWrapper) {
                mPlayersView.setContent(responseWrapper);
            }
        });
    }
}

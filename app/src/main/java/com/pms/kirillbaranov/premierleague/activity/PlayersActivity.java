package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.PlayersURL;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
import com.pms.kirillbaranov.premierleague.presenter.PlayersPresenter;
import com.pms.kirillbaranov.premierleague.ui.PlayersToolbar;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.ui.TeamsItemViewHolder;
import com.pms.kirillbaranov.premierleague.ui.helper.PlayersRecyclerViewAdapter;
import com.pms.kirillbaranov.premierleague.ui.helper.SimpleDividerItemDecoration;
import com.pms.kirillbaranov.premierleague.view.IPlayersView;

import java.util.Collection;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersActivity extends BackToolbarActivity implements IPlayersView {

    private ResponseWrapper mResponseWrapper;
    private String mPlayersURL;

    private ProgressBar mUpdatingProgressBar;
    private RecyclerView mPlayersRecyclerView;
    private PlayersRecyclerViewAdapter mPlayersAdapter;
    private PlayersToolbar mPlayersToolbar;
    private PlayersPresenter mPlayersPresenter;

    private RequestTask.IProgressBehavior mUpdatingProgressBehaviour = new RequestTask.IProgressBehavior() {
        @Override
        public void startTask() {
            mUpdatingProgressBar.setVisibility(View.VISIBLE);
            mPlayersToolbar.setTitle(R.string.updating_title);
        }

        @Override
        public void endTask() {
            mUpdatingProgressBar.setVisibility(View.INVISIBLE);
            mPlayersToolbar.setTitle(R.string.players_title);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initToolbar();

        mPlayersURL = getIntent().getStringExtra(PlayersURL.HREF);
        mPlayersPresenter.getCurrentPlayers(mPlayersURL);
    }

    public void initView() {
        mPlayersPresenter = new PlayersPresenter(this, mUpdatingProgressBehaviour);

        mPlayersRecyclerView = (RecyclerView) findViewById(R.id.players_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.players_progress_bar);

        initRecyclerView();
    }

    public void initRecyclerView() {
        mPlayersRecyclerView.setHasFixedSize(true);
        mPlayersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPlayersRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.simple_decoration_divider));

        mPlayersAdapter = new PlayersRecyclerViewAdapter();
        mPlayersRecyclerView.setAdapter(mPlayersAdapter);
    }

    public void initToolbar() {
        mPlayersToolbar = new PlayersToolbar(this, v -> finish());
        getToolbar().addView(mPlayersToolbar);
    }

    @Override
    public void setContent(ResponseWrapper responseWrapper) {
        mResponseWrapper = responseWrapper;
        mPlayersAdapter.setPlayers(responseWrapper.getPlayers());
    }
}

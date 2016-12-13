package com.pms.kirillbaranov.premierleague.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.PlayersURL;
import com.pms.kirillbaranov.premierleague.entity.Team;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
import com.pms.kirillbaranov.premierleague.presenter.LeagueTablePresenter;
import com.pms.kirillbaranov.premierleague.presenter.TeamsPresenter;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.ui.TeamsItemViewHolder;
import com.pms.kirillbaranov.premierleague.ui.helper.SimpleDividerItemDecoration;
import com.pms.kirillbaranov.premierleague.ui.helper.TableLeagueRecycleViewAdapter;
import com.pms.kirillbaranov.premierleague.ui.helper.TeamsRecyclerViewAdapter;
import com.pms.kirillbaranov.premierleague.view.ITeamsView;

import java.util.Collection;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public class TeamsActivity extends BaseAppSideMenuActivity implements ITeamsView {

    private ResponseWrapper mResponseWrapper;
    private ProgressBar mUpdatingProgressBar;
    private RecyclerView mTeamsRecyclerView;

    private Toolbar mToolbar;
    private TeamsRecyclerViewAdapter mTeamsAdapter;
    private TeamsPresenter mTeamsPresenter;

    private RequestTask.IProgressBehavior mUpdatingProgressBehaviour = new RequestTask.IProgressBehavior() {
        @Override
        public void startTask() {
            mUpdatingProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void endTask() {
            mUpdatingProgressBar.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams_layout);

        initView();
        initToolbar();
        mTeamsPresenter.getCurrentTeams();
    }

    private TeamsItemViewHolder.OnTeamClickListener mOnTeamClickListener = team -> {
        Intent intent = new Intent(this, PlayersActivity.class)
                .putExtra(PlayersURL.HREF, team.getLinks().getPlayersURL().getHref());
        startActivity(intent);
    };

    public void initView() {
        mTeamsPresenter = new TeamsPresenter(this, mUpdatingProgressBehaviour);

        mTeamsRecyclerView = (RecyclerView) findViewById(R.id.teams_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.teams_progress_bar);

        initRecyclerView();
    }

    public void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string._teams));
        setSupportActionBar(mToolbar);

        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        super.initToolbar(mToolbar);
    }

    private void initRecyclerView() {
        mTeamsRecyclerView.setHasFixedSize(true);
        mTeamsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTeamsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.simple_decoration_divider));

        mTeamsAdapter = new TeamsRecyclerViewAdapter(mOnTeamClickListener);
        mTeamsRecyclerView.setAdapter(mTeamsAdapter);
    }

    @Override
    public void setContent(ResponseWrapper responseWrapper) {
        mResponseWrapper = responseWrapper;
        mTeamsAdapter.setTeams(mResponseWrapper.getTeams());
    }
}

package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.LeagueTable;
import com.pms.kirillbaranov.premierleague.presenter.LeagueTablePresenter;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.ui.helper.SimpleDividerItemDecoration;
import com.pms.kirillbaranov.premierleague.ui.helper.TableLeagueRecycleViewAdapter;
import com.pms.kirillbaranov.premierleague.view.ITableLeagueView;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public class TableLeagueActivity extends BaseAppSideMenuActivity implements ITableLeagueView{

    private LeagueTable mLeagueTable;
    private ProgressBar mUpdatingProgressBar;
    private RecyclerView mTableLeagueRecyclerView;

    private Toolbar mToolbar;
    private TableLeagueRecycleViewAdapter mTableLeagueAdapter;
    private LeagueTablePresenter mTableLeaguePresenter;


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
        setContentView(R.layout.table_league_layout);

        initView();
        initToolbar();

        mTableLeaguePresenter.getCurrentLeagueTable();
    }

    public void initView() {
        mTableLeaguePresenter = new LeagueTablePresenter(this, mUpdatingProgressBehaviour);

        mTableLeagueRecyclerView = (RecyclerView) findViewById(R.id.table_league_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.table_league_progress_bar);

        initRecyclerView();
    }

    public void initToolbar() {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("League Table");
            setSupportActionBar(mToolbar);

            mToolbar.setTitleTextColor(getResources().getColor(R.color.black_opacity_54));
            super.initToolbar(mToolbar);
    }

    private void initRecyclerView() {
        mTableLeagueRecyclerView.setHasFixedSize(true);
        mTableLeagueRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTableLeagueRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.simple_decoration_divider));

        mTableLeagueAdapter = new TableLeagueRecycleViewAdapter();
        mTableLeagueRecyclerView.setAdapter(mTableLeagueAdapter);
    }

    @Override
    public void setContent(LeagueTable leagueTable) {
        mLeagueTable = leagueTable;
        mTableLeagueAdapter.setStandings(mLeagueTable.getStandings());
    }
}

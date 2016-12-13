package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
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

    private SwipeRefreshLayout mSwipeRefreshLayout;


    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = () -> {
        mSwipeRefreshLayout.setRefreshing(true);
        mTableLeaguePresenter.getCurrentLeagueTable();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_league_layout);

        initView();
        initToolbar();

        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.banner_ad_unit_id   ));
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mTableLeaguePresenter.getCurrentLeagueTable();
    }

    public void initView() {
        mTableLeaguePresenter = new LeagueTablePresenter(this);

        mTableLeagueRecyclerView = (RecyclerView) findViewById(R.id.table_league_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.table_league_progress_bar);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_container);
        mSwipeRefreshLayout.setDistanceToTriggerSync(200);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.primaryColor));
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        initRecyclerView();
    }

    public void initToolbar() {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("League Table");
            setSupportActionBar(mToolbar);

            mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
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
    public void startUpdating() {
        if (mTableLeagueAdapter.getItemCount() == 0) mUpdatingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void endUpdating() {
        if (mUpdatingProgressBar.getVisibility() == View.VISIBLE) mUpdatingProgressBar.setVisibility(View.INVISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setContent(LeagueTable leagueTable) {
        mLeagueTable = leagueTable;
        mTableLeagueAdapter.setStandings(mLeagueTable.getStandings());
    }
}

package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;
import com.pms.kirillbaranov.premierleague.presenter.FixturesPresenter;
import com.pms.kirillbaranov.premierleague.ui.RequestTask;
import com.pms.kirillbaranov.premierleague.ui.helper.FixturesRecyclerViewAdapter;
import com.pms.kirillbaranov.premierleague.ui.helper.SimpleDividerItemDecoration;
import com.pms.kirillbaranov.premierleague.view.IFixturesView;

import java.util.Collection;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public class FixturesActivity extends BaseAppSideMenuActivity implements IFixturesView {

    private ResponseWrapper mResponseWrapper;
    private ProgressBar mUpdatingProgressBar;
    private RecyclerView mFixturesRecyclerView;

    private Toolbar mToolbar;
    private FixturesRecyclerViewAdapter mFixturesAdapter;
    private FixturesPresenter mFixturesPresenter;

    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fixtures_layout);

        initView();
        initToolbar();
        mFixturesPresenter.getCurrentFixtures();
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = () -> {
        mSwipeRefreshLayout.setRefreshing(true);
        mFixturesPresenter.getCurrentFixtures();
    };

    public void initView() {
        mFixturesPresenter = new FixturesPresenter(this);

        mFixturesRecyclerView = (RecyclerView) findViewById(R.id.fixtures_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.fixtures_progress_bar);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_container);
        mSwipeRefreshLayout.setDistanceToTriggerSync(200);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.primaryColor));
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        initRecyclerView();
    }

    public void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Fixtures");
        setSupportActionBar(mToolbar);

        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        super.initToolbar(mToolbar);
    }

    private void initRecyclerView() {
        mFixturesRecyclerView.setHasFixedSize(true);
        mFixturesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFixturesRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.simple_decoration_divider));

        mFixturesAdapter = new FixturesRecyclerViewAdapter();
        mFixturesRecyclerView.setAdapter(mFixturesAdapter);
    }

    @Override
    public void setContent(ResponseWrapper responseWrapper) {
        mResponseWrapper = responseWrapper;
        mFixturesAdapter.setFixtures(mResponseWrapper.getFixtures());
    }

    @Override
    public void startUpdating() {
        if (mFixturesAdapter.getItemCount() == 0) mUpdatingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void endUpdating() {
        if (mUpdatingProgressBar.getVisibility() == View.VISIBLE) mUpdatingProgressBar.setVisibility(View.INVISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}

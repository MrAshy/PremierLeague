package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
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
        setContentView(R.layout.fixtures_layout);

        initView();
        initToolbar();
        mFixturesPresenter.getCurrentFixtures();
    }

    public void initView() {
        mFixturesPresenter = new FixturesPresenter(this, mUpdatingProgressBehaviour);

        mFixturesRecyclerView = (RecyclerView) findViewById(R.id.fixtures_recycler_view);
        mUpdatingProgressBar = (ProgressBar) findViewById(R.id.fixtures_progress_bar);

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
}

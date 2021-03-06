package com.pms.kirillbaranov.premierleague.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.percent.PercentFrameLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.ui.OnSingleClickListener;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by KirillBaranov on 05.12.16.
 */

public class BaseAppSideMenuActivity extends AppCompatActivity {

    private DrawerLayout mBaseDrawerLayout;
    private PercentFrameLayout mSideMenuDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    private Button mLeagueTableButton;
    private Button mTeamsButton;
    private Button mFixturesButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_app_side_layout);

        initView();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        ViewStub contentViewStub = (ViewStub) findViewById(R.id.content);
        contentViewStub.setLayoutResource(layoutResID);
        contentViewStub.inflate();
    }

    private void initView() {
        mBaseDrawerLayout = (DrawerLayout) findViewById(R.id.base_drawer_layout);
        mSideMenuDrawer = (PercentFrameLayout) findViewById(R.id.left_drawer);

        mLeagueTableButton = (Button) findViewById(R.id.league_table_button);
        mTeamsButton = (Button) findViewById(R.id.teams_button);
        mFixturesButton = (Button) findViewById(R.id.fixtures_button);
    }

    public void initToolbar(Toolbar toolbar) {
        initDrawer(toolbar);
        initListeners();
    }

    private void initDrawer(Toolbar toolbar) {
        mDrawerToggle = new ActionBarDrawerToggle(this, mBaseDrawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                Integer viewId = (Integer) view.getTag();
                if (viewId != null) {
                    selectItem(viewId);
                    view.setTag(null);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawerView.bringToFront();
                super.onDrawerOpened(drawerView);
            }
        };
    }

    public void setSideMenuEnable(boolean enable) {
        int drawerLockMode = enable ? DrawerLayout.LOCK_MODE_UNLOCKED : DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
        mBaseDrawerLayout.setDrawerLockMode(drawerLockMode);
        mDrawerToggle.setDrawerIndicatorEnabled(enable);
    }

    private void initListeners() {
        DrawerItemClickListener drawerItemClickListener = new DrawerItemClickListener();
        mBaseDrawerLayout.setDrawerListener(mDrawerToggle);
        Stream.of(mLeagueTableButton, mTeamsButton, mFixturesButton)
                .peek(view -> view.setOnClickListener(drawerItemClickListener)).collect(Collectors.toList());
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("BaseAppSideMenu Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class DrawerItemClickListener extends OnSingleClickListener {
        @Override
        public void onSingleClick(View v) {
            mSideMenuDrawer.setTag(v.getId());
            mBaseDrawerLayout.closeDrawer(mSideMenuDrawer);
        }
    }

    private void selectItem(int viewId) {
        switch (viewId) {
            case R.id.league_table_button:
                startActivity(new Intent(this, TableLeagueActivity.class));
                break;
            case R.id.teams_button:
                startActivity(new Intent(this, TeamsActivity.class));
                break;
            case R.id.fixtures_button:
                startActivity(new Intent(this, FixturesActivity.class));
                break;
            default:
                break;
        }
    }

    private boolean isSameScreen(Class<? extends Activity> actvityClass) {
        return getClass().getSimpleName().equals(actvityClass.getSimpleName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



}

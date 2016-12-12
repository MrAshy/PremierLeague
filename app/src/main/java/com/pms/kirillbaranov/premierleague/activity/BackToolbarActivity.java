package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;

import com.pms.kirillbaranov.premierleague.R;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public abstract class BackToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.toolbar_layout);

        initializeToolbar();
    }

    @Override
    public void setContentView(int layoutResID) {
        ViewStub contentViewStub = (ViewStub) findViewById(R.id.content);
        contentViewStub.setLayoutResource(layoutResID);
        contentViewStub.inflate();
    }

    private void initializeToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }


}

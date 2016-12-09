package com.pms.kirillbaranov.premierleague.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pms.kirillbaranov.premierleague.R;

/**
 * Created by KirillBaranov on 05.12.16.
 */

public class BaseAppSideMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_app_side_layout);
    }

}

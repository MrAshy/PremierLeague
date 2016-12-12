package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pms.kirillbaranov.premierleague.R;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersToolbar extends RelativeLayout {

    private TextView mTitleTextView;
    private TextView mBackButton;

    public PlayersToolbar(Context context, View.OnClickListener onBackButtonClickListener) {
        super(context);
        inflate(context, R.layout.players_toolbar_layout, this);
        initView(onBackButtonClickListener);
    }

    private void initView(View.OnClickListener onBackButtonClickListener) {
        mTitleTextView = (TextView) findViewById(R.id.title);

        mBackButton = (TextView) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(onBackButtonClickListener);
    }

    public void setTitle(int stringId) {
        mTitleTextView.setText(stringId);
    }
}

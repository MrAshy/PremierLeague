package com.pms.kirillbaranov.premierleague.ui;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public abstract class OnSingleClickListener implements View.OnClickListener {

    private static final int THRESHOLD = 300;
    private long mLastClickTime = 0;

    /**
     * {@code  if(lastClickTime  < THRESHOLD)} The view click, not be performed.
     *
     * @param v {@link View} to click
     */
    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < THRESHOLD) return;
        mLastClickTime = SystemClock.elapsedRealtime();

        onSingleClick(v);
    }

}

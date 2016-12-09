package com.pms.kirillbaranov.premierleague.utils;

import android.content.Context;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class ViewUtils {

    public static int getScaleDimensions(Context context, float rawPixelSize){
        final float scale = context.getResources().getDisplayMetrics().density;
        //because of this, see link http://developer.android.com/guide/practices/screens_support.html#dips-pels
        //Google says (Then add 0.5f to round the figure up to the nearest whole number, when converting to an integer.)
        return (int) (rawPixelSize * scale + 0.5f);
    }
}

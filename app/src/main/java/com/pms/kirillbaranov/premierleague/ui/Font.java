package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by KirillBaranov on 05.12.16.
 */

public enum Font {
    ROBOTO_CONDENSED("fonts/roboto_condensed.ttf"),
    ROBOTO_LIGHT("fonts/roboto_light.ttf"),
    ROBOTO_REGULAR("fonts/roboto_regular.ttf"),
    FONTELLO("fonts/fontello.ttf"),
    WEBHOSTINGHUB_GLYPHS("fonts/webhostinghub_glyphs.ttf"),
    ROBOTO_BOLD("fonts/roboto_bold.ttf"),
    ROBOTO_BLACK("fonts/roboto_black.ttf"),
    ROBOTO_THIN("fonts/roboto_thin.ttf"),
    ROBOTO_BOLD_CONDENSED("fonts/roboto_bold_condensed.ttf"),
    ROBOTO_CONDENSED_ITALIC("fonts/roboto_condensed_italic.ttf"),
    IONICONS("fonts/ionicons.ttf"),
    ROBOTO_CONDENSED_LIGHT("fonts/roboto_condensed_light.ttf"),
    ROBOTO_MEDIUM("fonts/roboto_medium.ttf"),
    STREAMLINE_24PX("fonts/streamline_24px.ttf"),
    STREAMLINE_24PX_FILLED_IN("fonts/streamline_24px_filled_in.ttf"),
    ICOMOON("fonts/icomoon.ttf"),
    ;

    private String fontPath;
    private Typeface mTypeFace;

    private Font(String fontPath) {
        this.fontPath = fontPath;
    }

    public Typeface getFont(Context context) {
        if (mTypeFace == null) {

            try {
                mTypeFace = Typeface.createFromAsset(context.getAssets(), fontPath);
            } catch (Exception e) {
                mTypeFace = Typeface.SANS_SERIF;
                String message = "The " + fontPath + " not found! (Typeface.SANS_SERIF set by default) /n"
                        + "The sky will fall on you, if you don't add required font, to assets folder! " + e.getMessage();
                Log.w("Font", message);
            }

        }
        return mTypeFace;
    }

    public String getPrefix() {
        return fontPath;
    }

    public static Typeface getByIndex(int index, Context context) {
        return values()[index].getFont(context);
    }
}
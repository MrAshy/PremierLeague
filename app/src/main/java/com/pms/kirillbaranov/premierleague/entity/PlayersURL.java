package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersURL {

    public static final String HREF = "href";

    @SerializedName(PlayersURL.HREF)
    private String href;

    public String getHref() {
        return href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayersURL playersURL = (PlayersURL) o;

        return playersURL.equals(playersURL.href);
    }

    @Override
    public int hashCode() {
        int result = href.hashCode();
        return result;
    }
}

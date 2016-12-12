package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Link {

    public static final String PLAYERS_URL = "players";

    @SerializedName(Link.PLAYERS_URL)
    private PlayersURL playersURL;

    public PlayersURL getPlayersURL() {
        return playersURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        return playersURL.equals(link.playersURL);
    }

    @Override
    public int hashCode() {
        int result = playersURL.hashCode();
        return result;
    }
}

package com.pms.kirillbaranov.premierleague.entity.Wrapper;

import com.google.gson.annotations.SerializedName;
import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.entity.Player;
import com.pms.kirillbaranov.premierleague.entity.Team;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class ResponseWrapper {

    public static final String TEAMS = "teams";
    public static final String FIXTURES = "fixtures";
    public static final String PLAYERS = "players";

    @SerializedName(ResponseWrapper.TEAMS)
    private Collection<Team> teams;

    @SerializedName(ResponseWrapper.FIXTURES)
    private Collection<Fixture> fixtures;

    @SerializedName(ResponseWrapper.PLAYERS)
    private Collection<Player> players;

    public Collection<Team> getTeams() {
        return teams;
    }

    public Collection<Fixture> getFixtures() {
        return fixtures;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseWrapper responseWrapper = (ResponseWrapper) o;

        if (!teams.equals(responseWrapper.teams)) return false;
        if (!players.equals(responseWrapper.players)) return false;
        return fixtures.equals(responseWrapper.fixtures);
    }


    @Override
    public int hashCode() {
        int result = teams.hashCode();
        result = 31 * result + fixtures.hashCode();
        result = 31 * result + players.hashCode();
        return result;
    }
}

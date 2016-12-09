package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class LeagueTable  {

    public static final String LEAGUE_CAPTION = "leagueCaption";
    public static final String MATCHDAY = "matchday";
    public static final String STANDING = "standing";

    @SerializedName(LeagueTable.LEAGUE_CAPTION)
    private String leagueCaption;

    @SerializedName(LeagueTable.MATCHDAY)
    private int matchday;

    @SerializedName(LeagueTable.STANDING)
    private Collection<Standing> standings;

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public int getMatchday() {
        return matchday;
    }

    public Collection<Standing> getStandings() {
        return standings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueTable leagueTable = (LeagueTable) o;

        if (!leagueCaption.equals(leagueTable.leagueCaption)) return false;
        if (matchday != matchday) return false;
        return standings.equals(leagueTable.standings);
    }

    @Override
    public int hashCode() {
        int result = leagueCaption.hashCode();
        result = 31 * result + matchday;
        result = 31 * result + standings.hashCode();
        return result;
    }
}

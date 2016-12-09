package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Competition {

    public static final String COMPETITION_ID = "id";
    public static final String CAPTION = "caption";
    public static final String LEAGUE = "league";
    public static final String CURRENT_MATCHDAY = "currentMatchday";
    public static final String NUMBER_OF_MATCHDAYS = "numberOfMatchdays";
    public static final String NUMBER_OF_TEAMS = "numberOfTeams";

    @SerializedName(Competition.COMPETITION_ID)
    private int id;

    @SerializedName(Competition.CAPTION)
    private String caption;

    @SerializedName(Competition.LEAGUE)
    private String league;

    @SerializedName(Competition.CURRENT_MATCHDAY)
    private int currentMatchday;

    @SerializedName(Competition.NUMBER_OF_MATCHDAYS)
    private int numberOfMatchdays;

    @SerializedName(Competition.NUMBER_OF_TEAMS)
    private int numberOfTeams;

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getLeague() {
        return league;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition competition = (Competition) o;

        if (id != competition.id) return false;
        if (!caption.equals(competition.caption)) return false;
        if (currentMatchday != competition.currentMatchday) return false;
        if (numberOfMatchdays != competition.numberOfMatchdays) return false;
        if (numberOfTeams != competition.numberOfTeams) return false;
        return league.equals(competition.league);
    }

    @Override
    public int hashCode() {
        int result = caption.hashCode();
        result = 31 * result + id;
        result = 31 * result + league.hashCode();
        result = 31 * result + currentMatchday;
        result = 31 * result + numberOfMatchdays;
        result = 31 * result + numberOfTeams;
        return result;
    }
}

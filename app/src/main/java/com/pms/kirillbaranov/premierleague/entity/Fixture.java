package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;
import com.pms.kirillbaranov.premierleague.utils.DateHelper;

import java.util.Date;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Fixture {

    public static final String DATE = "date";
    public static final String STATUS = "status";
    public static final String MATCHDAY = "matchday";
    public static final String HOME_TEAM_NAME = "homeTeamName";
    public static final String AWAY_TEAM_NAME = "awayTeamName";
    public static final String RESULT = "result";

    @SerializedName(Fixture.DATE)
    private String date;

    @SerializedName(Fixture.STATUS)
    private String status;

    @SerializedName(Fixture.MATCHDAY)
    private int matchday;

    @SerializedName(Fixture.HOME_TEAM_NAME)
    private String homeTeamName;

    @SerializedName(Fixture.AWAY_TEAM_NAME)
    private String awayTeamName;

    @SerializedName(Fixture.RESULT)
    private Result result;

    public Date getDate() {
        return DateHelper.parseUtcIso(date);
    }

    public String getStatus() {
        return status;
    }

    public int getMatchday() {
        return matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fixture fixture = (Fixture) o;

        if (!date.equals(fixture.date)) return false;
        if (!status.equals(fixture.status)) return false;
        if (matchday != fixture.matchday) return false;
        if (!homeTeamName.equals(fixture.homeTeamName)) return false;
        if (!awayTeamName.equals(fixture.awayTeamName)) return false;
        return result.equals(fixture.result);
    }

    @Override
    public int hashCode() {
        int resultItem = date.hashCode();
        resultItem = 31 * resultItem + status.hashCode();
        resultItem = 31 * resultItem + matchday;
        resultItem = 31 * resultItem + homeTeamName.hashCode();
        resultItem = 31 * resultItem + awayTeamName.hashCode();
        resultItem = 31 * resultItem + result.hashCode();
        return resultItem;
    }
}

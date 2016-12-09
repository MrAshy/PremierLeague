package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KirillBaranov on 07.12.16.
 */

public class Result {
    public static final String GOALS_HOME_TEAM = "goalsHomeTeam";
    public static final String GOALS_AWAY_TEAM = "goalsAwayTeam";

    @SerializedName(Result.GOALS_HOME_TEAM)
    private int goalsHomeTeam;

    @SerializedName(Result.GOALS_AWAY_TEAM)
    private int goalsAwayTeam;

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (goalsHomeTeam != result.goalsHomeTeam) return false;
        return (goalsAwayTeam == result.goalsAwayTeam);
    }

    @Override
    public int hashCode() {
        int result = goalsHomeTeam;
        result = 31 * result + goalsAwayTeam;
        return result;
    }
}

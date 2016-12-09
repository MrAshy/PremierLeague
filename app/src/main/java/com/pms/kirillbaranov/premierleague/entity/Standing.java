package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

import static com.pms.kirillbaranov.premierleague.utils.StringUtils.EMPTY_STRING;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Standing {

    public static final String POSITION = "position";
    public static final String TEAM = "teamName";
    public static final String PLAYED_GAMES = "playedGames";
    public static final String CREST_URI = "crestURI";
    public static final String POINTS = "points";
    public static final String GOALS = "goals";
    public static final String GOALS_AGAINST = "goalsAgainst";
    public static final String GOAL_DIFFERENCE = "goalDifference";
    public static final String WINS = "wins";
    public static final String DRAWS = "draws";
    public static final String LOSSES = "losses";

    @SerializedName(Standing.POSITION)
    private int rank;

    @SerializedName(Standing.TEAM)
    private String team;

    @SerializedName(Standing.PLAYED_GAMES)
    private int playedGamesCount;

    @SerializedName(Standing.CREST_URI)
    private String imageUri;

    @SerializedName(Standing.POINTS)
    private int points;

    @SerializedName(Standing.GOALS)
    private int goals;

    @SerializedName(Standing.GOALS_AGAINST)
    private int goalsAgainst;

    @SerializedName(Standing.GOAL_DIFFERENCE)
    private int goalDifference;

    @SerializedName(Standing.WINS)
    private int wins;

    @SerializedName(Standing.DRAWS)
    private int draws;

    @SerializedName(Standing.LOSSES)
    private int losses;

    public int getRank() {
        return rank;
    }

    public String getTeam() {
        return team;
    }

    public int getPlayedGamesCount() {
        return playedGamesCount;
    }

    public String getImageUri() {
        return EMPTY_STRING.equals(imageUri) || imageUri.contains(" ")? "http://www.futurumglobal.com/files/4714/2166/9833/generic-profile.png" : imageUri;
    }

    public int getPoints() {
        return points;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Standing standing = (Standing) o;

        if (rank != standing.rank) return false;
        if (!team.equals(standing.team)) return false;
        if (playedGamesCount != standing.playedGamesCount) return false;
        if (points != standing.points) return false;
        if (goals != standing.goals) return false;
        if (goalsAgainst != standing.goalsAgainst) return false;
        if (goalDifference != standing.goalDifference) return false;
        if (wins != standing.wins) return false;
        if (draws != standing.draws) return false;
        if (losses != standing.losses) return false;
        return imageUri.equals(standing.imageUri);
    }

    @Override
    public int hashCode() {
        int result = team.hashCode();
        result = 31 * result + rank;
        result = 31 * result + playedGamesCount;
        result = 31 * result + points;
        result = 31 * result + goals;
        result = 31 * result + goalsAgainst;
        result = 31 * result + goalDifference;
        result = 31 * result + wins;
        result = 31 * result + draws;
        result = 31 * result + losses;
        result = 31 * result + imageUri.hashCode();
        return result;
    }
}

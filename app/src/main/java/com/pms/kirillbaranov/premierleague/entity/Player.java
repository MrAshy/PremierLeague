package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;
import com.pms.kirillbaranov.premierleague.utils.DateHelper;

import java.util.Date;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Player {

    public static final String NAME = "name";
    public static final String POSITION = "position";
    public static final String JERSEY_NUMBER = "jerseyNumber";
    public static final String BIRTHDAY = "dateOfBirth";
    public static final String NATIONALITY = "nationality";
    public static final String MARKET_VALUE = "marketValue";

    @SerializedName(Player.NAME)
    private String name;

    @SerializedName(Player.POSITION)
    private String position;

    @SerializedName(Player.JERSEY_NUMBER)
    private int jerseyNumber;

    @SerializedName(Player.BIRTHDAY)
    private String birthday;

    @SerializedName(Player.NATIONALITY)
    private String nationality;

    @SerializedName(Player.MARKET_VALUE)
    private String marketValue;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public Date getBirthday() {
        return DateHelper.parseUtcIso(birthday);
    }

    public String getNationality() {
        return nationality;
    }

    public String getMarketValue() {
        return marketValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        if (!name.equals(player.name)) return false;
        if (!position.equals(player.position)) return false;
        if (jerseyNumber != player.jerseyNumber) return false;
        if (!birthday.equals(player.birthday)) return false;
        if (!nationality.equals(player.nationality)) return false;
        return marketValue.equals(player.marketValue);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + jerseyNumber;
        result = 31 * result + birthday.hashCode();
        result = 31 * result + nationality.hashCode();
        result = 31 * result + marketValue.hashCode();
        return result;
    }
}

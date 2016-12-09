package com.pms.kirillbaranov.premierleague.entity;

import com.google.gson.annotations.SerializedName;

import java.util.jar.Attributes;

import static com.pms.kirillbaranov.premierleague.entity.Team.NAME;
import static com.pms.kirillbaranov.premierleague.utils.StringUtils.EMPTY_STRING;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class Team {

    public static final String NAME = "name";
    public static final String CODE = "code";
    public static final String SHORT_NAME = "shortName";
    public static final String SQUAD_MARKET_VALUE = "squadMarketValue";
    public static final String IMAGE_URL = "crestUrl";

    @SerializedName(NAME)
    private String name;

    @SerializedName(Team.CODE)
    private String code;

    @SerializedName(Team.SHORT_NAME)
    private String shortName;

    @SerializedName(Team.SQUAD_MARKET_VALUE)
    private String squadMarketValue;

    @SerializedName(Team.IMAGE_URL)
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public String getImageUrl() {
        return EMPTY_STRING.equals(imageUrl) || imageUrl.contains(" ")? "http://www.futurumglobal.com/files/4714/2166/9833/generic-profile.png" : imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!name.equals(team.name)) return false;
        if (!code.equals(team.code)) return false;
        if (!shortName.equals(team.shortName)) return false;
        if (!squadMarketValue.equals(team.squadMarketValue)) return false;
        return  (imageUrl.equals(team.imageUrl));
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + shortName.hashCode();
        result = 31 * result + squadMarketValue.hashCode();
        result = 31 * result + imageUrl.hashCode();
        return result;
    }
}

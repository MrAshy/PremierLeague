package com.pms.kirillbaranov.premierleague.api;

import com.annimon.stream.Stream;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pms.kirillbaranov.premierleague.entity.LeagueTable;
import com.pms.kirillbaranov.premierleague.entity.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by KirillBaranov on 04.12.16.
 */

public class ServerApi {

    private static final String URL = "http://api.football-data.org/v1/";
    private static final String TOKEN_KEY_NAME = "X-Auth-Token";
    private static final String TOKEN_KEY_VALUE = "54d182d8d9c74bd89ca275fa325d2e24";

    private final static ServerApi sInstance = new ServerApi();

    public static ServerApi getInstance() {
        return sInstance;
    }

    private <Result> Collection<Result> getResponse(boolean singleObject, String uri, Class<Result> type) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header(TOKEN_KEY_NAME, TOKEN_KEY_VALUE)
                .url(URL + uri)
                .build();

        String responseString = null;
        try {
            Response response = client.newCall(request).execute();
            responseString = response.body().string();
        } catch (IOException e) {
            //TODO Handle problems..
            e.printStackTrace();
        }

        if (singleObject) {
            Result entity = new Gson().fromJson(responseString, type);
            return Collections.singletonList(entity);

        } else {
            Collection<Result> lst = new ArrayList<>();
            for (final JsonElement json : new JsonParser().parse(responseString).getAsJsonArray()) {
                Result entity = new Gson().fromJson(json, type);
                lst.add(entity);
            }
            return lst;
        }
    }

    private <Result> Collection<Result> getArrayResponse(String uri, Class<Result> type) {
        return getResponse(false, uri, type);
    }

    private <Result> Result getObjectResponse(String uri, Class<Result> type) {
        Collection<Result> response = getResponse(true, uri, type);
        return Stream.of(response).findFirst().orElse(null);
    }

    public LeagueTable readLeagueTable() {
        LeagueTable leagueTable = getObjectResponse("competitions/426/leagueTable", LeagueTable.class);
        return leagueTable;
    }

    private Collection<Team> readTeams() {
        return getArrayResponse("competitions/426/teams", Team.class);
    }
    

}

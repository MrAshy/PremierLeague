package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.LeagueTable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by KirillBaranov on 09.12.16.
 */

public class TableLeagueBusiness {

    public LeagueTable readTableLeague() {
        LeagueTable leagueTable = ServerApi.getInstance().readLeagueTable();
        return leagueTable;
    }
}

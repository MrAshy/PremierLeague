package com.pms.kirillbaranov.premierleague.model;

import com.pms.kirillbaranov.premierleague.business.TableLeagueBusiness;
import com.pms.kirillbaranov.premierleague.entity.LeagueTable;

/**
 * Created by KirillBaranov on 09.12.16.
 */

public class TableLeagueModel {

    public LeagueTable readLeagueTable() {
        return new TableLeagueBusiness().readTableLeague();
    }
}

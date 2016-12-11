package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.Team;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsBusiness {

    public Collection<Team> readTeams() {
        Collection<Team> teams = ServerApi.getInstance().readTeams();
        return teams;
    }
}

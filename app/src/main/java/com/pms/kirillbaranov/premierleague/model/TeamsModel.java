package com.pms.kirillbaranov.premierleague.model;

import com.pms.kirillbaranov.premierleague.business.TeamsBusiness;
import com.pms.kirillbaranov.premierleague.entity.Team;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsModel {

    public Collection<Team> getTeams() {
        return new TeamsBusiness().readTeams();
    }
}

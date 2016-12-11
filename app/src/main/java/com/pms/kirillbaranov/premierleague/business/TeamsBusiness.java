package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.Team;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsBusiness {

    public ResponseWrapper readTeams() {
        ResponseWrapper responseWrapper = ServerApi.getInstance().readTeams();
        return responseWrapper;
    }
}

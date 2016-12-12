package com.pms.kirillbaranov.premierleague.model;

import com.pms.kirillbaranov.premierleague.business.PlayersBusiness;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersModel {

    public ResponseWrapper getPlayers(String playersURL) {
        return new PlayersBusiness().readPlayers(playersURL);
    }

}

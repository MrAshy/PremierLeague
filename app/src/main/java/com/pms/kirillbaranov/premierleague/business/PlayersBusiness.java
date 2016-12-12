package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersBusiness {

    public ResponseWrapper readPlayers(String playersUrl) {
        ResponseWrapper responseWrapper = ServerApi.getInstance().readPlayers(playersUrl);
        return responseWrapper;
    }

}

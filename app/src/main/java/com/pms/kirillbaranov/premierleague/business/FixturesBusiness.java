package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.entity.Wrapper.ResponseWrapper;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesBusiness {

    public ResponseWrapper readFixtures() {
        ResponseWrapper responseWrapper = ServerApi.getInstance().readFixtures();
        return responseWrapper;
    }
}

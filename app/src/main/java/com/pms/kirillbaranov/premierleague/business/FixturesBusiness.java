package com.pms.kirillbaranov.premierleague.business;

import com.pms.kirillbaranov.premierleague.api.ServerApi;
import com.pms.kirillbaranov.premierleague.entity.Fixture;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesBusiness {

    public Collection<Fixture> readFixtures() {
        Collection<Fixture> fixtures = ServerApi.getInstance().readFixtures();
        return fixtures;
    }
}

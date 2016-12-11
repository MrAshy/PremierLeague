package com.pms.kirillbaranov.premierleague.model;

import com.pms.kirillbaranov.premierleague.business.FixturesBusiness;
import com.pms.kirillbaranov.premierleague.entity.Fixture;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesModel {

    public Collection<Fixture> getFixtures() {
        return new FixturesBusiness().readFixtures();
    }
}

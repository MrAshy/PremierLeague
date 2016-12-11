package com.pms.kirillbaranov.premierleague.view;

import com.pms.kirillbaranov.premierleague.entity.Fixture;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public interface IFixturesView {
    public void setContent(Collection<Fixture> fixtures);
}

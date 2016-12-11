package com.pms.kirillbaranov.premierleague.view;

import com.pms.kirillbaranov.premierleague.entity.Team;

import java.util.Collection;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public interface ITeamsView {
    void setContent(Collection<Team> teams);
}

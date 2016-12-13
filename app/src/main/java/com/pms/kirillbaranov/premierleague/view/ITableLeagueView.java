package com.pms.kirillbaranov.premierleague.view;

import com.pms.kirillbaranov.premierleague.entity.LeagueTable;
import com.pms.kirillbaranov.premierleague.entity.Standing;

import java.util.Collection;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public interface ITableLeagueView {
    void setContent(LeagueTable leagueTable, boolean isViewRefreshed);
    void startUpdating(boolean isViewRefreshed);
    void endUpdating();
}

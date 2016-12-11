package com.pms.kirillbaranov.premierleague.ui.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Fixture;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesItemViewHolder extends RecyclerView.ViewHolder{

    private TextView mDateTextView;
    private TextView mGameStatusTextView;
    private TextView mHomeTeamTextView;
    private TextView mAwayTeamTextView;
    private TextView mHomeGoalsTextView;
    private TextView mAwayGoalsTextView;


    public FixturesItemViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    public void initView(View view) {
        mDateTextView = (TextView) view.findViewById(R.id.date_value_text_view);
        mGameStatusTextView = (TextView) view.findViewById(R.id.status_value_text_view);
        mHomeTeamTextView = (TextView) view.findViewById(R.id.home_team_text_view);
        mHomeGoalsTextView = (TextView) view.findViewById(R.id.home_team_goals_text_view);
        mAwayTeamTextView = (TextView) view.findViewById(R.id.away_team_text_view);
        mAwayGoalsTextView = (TextView) view.findViewById(R.id.away_team_goals_text_view);
    }

    public void setContent(Fixture fixture) {
        String date = String.valueOf(fixture.getDate());
        mDateTextView.setText(date);

        mGameStatusTextView.setText(fixture.getStatus());
        mHomeTeamTextView.setText(fixture.getHomeTeamName());
        mAwayTeamTextView.setText(fixture.getAwayTeamName());

        String homeGoals = String.valueOf(fixture.getResult().getGoalsHomeTeam());
        mHomeGoalsTextView.setText(homeGoals);

        String awayGoals = String.valueOf(fixture.getResult().getGoalsAwayTeam());
        mAwayGoalsTextView.setText(awayGoals);
    }

}

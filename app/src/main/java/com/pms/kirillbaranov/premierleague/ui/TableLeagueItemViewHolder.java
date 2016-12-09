package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Standing;
import com.pms.kirillbaranov.premierleague.utils.ImageLoaderManager;

import org.w3c.dom.Text;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public class TableLeagueItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mRankingTextView;
    private ImageView mTeamImageView;
    private TextView mTeamNameTextView;
    private TextView mGamesCountTextView;
    private TextView mGamesWinTextView;
    private TextView mGamesDrawnTextView;
    private TextView mGamesLosesTextView;
    private TextView mGoalsTextView;
    private TextView mGoalsAgainstTextView;
    private TextView mGoalsDifferenceTextView;
    private TextView mPointsTextView;

    public TableLeagueItemViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    public void initView(View view) {
        mRankingTextView = (TextView) view.findViewById(R.id.ranking_text_view);
        mTeamImageView = (ImageView) view.findViewById(R.id.team_image_view);
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_text_view);
        mGamesCountTextView = (TextView) view.findViewById(R.id.games_count_text_view);
        mGamesWinTextView = (TextView) view.findViewById(R.id.games_wins_text_view);
        mGamesDrawnTextView = (TextView) view.findViewById(R.id.games_drawn_text_view);
        mGamesLosesTextView = (TextView) view.findViewById(R.id.games_loses_text_view);
        mGoalsTextView = (TextView) view.findViewById(R.id.goals_text_view);
        mGoalsAgainstTextView = (TextView) view.findViewById(R.id.goals_against_text_view);
        mGoalsDifferenceTextView = (TextView) view.findViewById(R.id.goals_difference_text_view);
        mPointsTextView = (TextView) view.findViewById(R.id.points_text_view);
    }

    public void setContent(Standing standing) {
        Log.d("all","dasdasdasdasdsad");
        Context context = mTeamImageView.getContext();
        String teamImageURL = standing.getImageUri();

        ImageLoaderManager.getInstance(context).displayImage(teamImageURL, mTeamImageView);

        String rank = String.valueOf(standing.getRank());
        mRankingTextView.setText(rank);

        mTeamNameTextView.setText(standing.getTeam());

        String gamesCount = String.valueOf(standing.getPlayedGamesCount());
        mGamesCountTextView.setText(gamesCount);

        String gamesWin = String.valueOf(standing.getWins());
        mGamesWinTextView.setText(gamesWin);

        String gamesDrawn = String.valueOf(standing.getDraws());
        mGamesDrawnTextView.setText(gamesDrawn);

        String gamesLoses = String.valueOf(standing.getLosses());
        mGamesLosesTextView.setText(gamesLoses);

        String goals = String.valueOf(standing.getGoals());
        mGoalsTextView.setText(goals);

        String goalsAgainst = String.valueOf(standing.getGoalsAgainst());
        mGoalsAgainstTextView.setText(goalsAgainst);

        String goalsDifference = String.valueOf(standing.getGoalDifference());
        mGoalsDifferenceTextView.setText(goalsDifference);

        String points = String.valueOf(standing.getPoints());
        mPointsTextView.setText(points);

    }
}

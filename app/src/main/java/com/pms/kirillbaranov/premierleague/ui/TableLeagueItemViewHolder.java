package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Standing;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgDecoder;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgDrawableTranscoder;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgSoftwareLayerSetter;
import com.pms.kirillbaranov.premierleague.utils.ImageLoaderManager;

import org.w3c.dom.Text;

import java.io.InputStream;

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

    private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

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
        Context context = mTeamImageView.getContext();
        String teamImageURL = standing.getImageUri();

        parseSVG(context,teamImageURL);

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

    public void parseSVG(Context context, String teamImageURL) {
        if (teamImageURL.endsWith(".png")) {
            ImageLoaderManager.getInstance(context).displayImage(teamImageURL, mTeamImageView);
        }
        if (teamImageURL.endsWith(".svg")) {
            requestBuilder = Glide.with(context)
                    .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
                    .from(Uri.class)
                    .as(SVG.class)
                    .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                    .sourceEncoder(new StreamEncoder())
                    .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                    .decoder(new SvgDecoder())
                    .animate(android.R.anim.fade_in)
                    .listener(new SvgSoftwareLayerSetter<Uri>());

            Uri uri = Uri.parse(teamImageURL);

            requestBuilder
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    // SVG cannot be serialized so it's not worth to cache it
                    .load(uri)
                    .into(mTeamImageView);
        }

    }
}

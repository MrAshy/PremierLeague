package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
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
import com.pms.kirillbaranov.premierleague.entity.Team;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgDecoder;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgDrawableTranscoder;
import com.pms.kirillbaranov.premierleague.ui.helper.SvgSoftwareLayerSetter;
import com.pms.kirillbaranov.premierleague.utils.ImageLoaderManager;

import java.io.InputStream;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsItemViewHolder extends RecyclerView.ViewHolder {

    private Team mTeam;

    private TextView mTeamNameTextView;
    private TextView mTeamCodeTextView;
    private TextView mTeamMarketValueTextView;
    private ImageView mTeamImageView;

    private OnTeamClickListener mOnTeamClickListener;

    private OnSingleClickListener mOnTeamClick = new OnSingleClickListener() {
        @Override
        public void onSingleClick(View v) {
            mOnTeamClickListener.onTeamClick(mTeam);
        }
    };


    private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;

    public TeamsItemViewHolder(View itemView, OnTeamClickListener onTeamClickListener) {
        super(itemView);

        initView(itemView);
        mOnTeamClickListener = onTeamClickListener;
    }

    private void initView(View view) {
        view.setOnClickListener(mOnTeamClick);
        mTeamNameTextView = (TextView) view.findViewById(R.id.teams_name_text_view);
        mTeamCodeTextView = (TextView) view.findViewById(R.id.teams_code_text_view);
        mTeamMarketValueTextView = (TextView) view.findViewById(R.id.market_value_text_view);
        mTeamImageView = (ImageView) view.findViewById(R.id.teams_team_image_view);
    }

    public void setContent(Team team) {
        mTeam = team;
        Context context = mTeamImageView.getContext();
        String teamImageURL = team.getImageUrl();

        parseSVG(context, teamImageURL);

        mTeamNameTextView.setText(team.getName());
        mTeamCodeTextView.setText(team.getCode());
        mTeamMarketValueTextView.setText(team.getSquadMarketValue());
    }

    private void parseSVG(Context context, String teamImageURL) {
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

    public interface OnTeamClickListener {
        void onTeamClick(Team team);
    }
}

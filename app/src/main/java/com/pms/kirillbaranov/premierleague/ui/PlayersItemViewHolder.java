package com.pms.kirillbaranov.premierleague.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Player;
import com.pms.kirillbaranov.premierleague.utils.DateHelper;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersItemViewHolder extends RecyclerView.ViewHolder {

    private TextView mNumberTextView;
    private TextView mNameTextView;
    private TextView mPositionTextView;
    private TextView mAgeTextView;
    private TextView mMarketValueTextView;
    private TextView mNationalityTextView;


    public PlayersItemViewHolder(View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View view) {
        mNumberTextView = (TextView) view.findViewById(R.id.players_number_text_view);
        mNameTextView = (TextView) view.findViewById(R.id.players_name_text_view);
        mPositionTextView = (TextView) view.findViewById(R.id.players_position_text_view);
        mAgeTextView = (TextView) view.findViewById(R.id.players_birthday_text_view);
        mMarketValueTextView = (TextView) view.findViewById(R.id.players_market_value_text_view);
        mNationalityTextView = (TextView) view.findViewById(R.id.players_nationality_text_view);
    }

    public void setContent(Player player) {
        String number = String.valueOf(player.getJerseyNumber());
        mNumberTextView.setText("#"+number);

        mNameTextView.setText(player.getName());
        mPositionTextView.setText(R.string._position + player.getPosition());

        String birthday = DateHelper.DATE_FORMATTER.format(player.getBirthday());
        mAgeTextView.setText(birthday);

        mMarketValueTextView.setText(R.string._marketValue + player.getMarketValue());
        mNationalityTextView.setText(R.string._nationality + player.getNationality());

    }



}

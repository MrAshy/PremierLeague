package com.pms.kirillbaranov.premierleague.ui.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Player;
import com.pms.kirillbaranov.premierleague.ui.PlayersItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by KirillBaranov on 12.12.16.
 */

public class PlayersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Player> mPlayers;

    PlayersRecyclerViewAdapter() { mPlayers = new ArrayList<>(); }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_item_layout, parent, false);
        return new PlayersItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PlayersItemViewHolder) holder).setContent(mPlayers.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

    public void setFixtures(Collection<Player> players) {
        if (!mPlayers.isEmpty()) mPlayers.clear();

        mPlayers.addAll(players);
        notifyDataSetChanged();
    }

    public void clear() {
        if (!mPlayers.isEmpty()) mPlayers.clear();
        notifyDataSetChanged();
    }
}

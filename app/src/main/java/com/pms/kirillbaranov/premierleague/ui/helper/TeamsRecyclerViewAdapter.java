package com.pms.kirillbaranov.premierleague.ui.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Team;
import com.pms.kirillbaranov.premierleague.ui.TeamsItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class TeamsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Team> mTeams;

    public TeamsRecyclerViewAdapter() { mTeams = new ArrayList<>(); }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_item_layout, parent, false);
        return new TeamsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TeamsItemViewHolder) holder).setContent(mTeams.get(position));
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    public void setTeams(Collection<Team> teams) {
        if (!mTeams.isEmpty()) mTeams.clear();

        mTeams.addAll(teams);
        notifyDataSetChanged();
    }

    public void clear() {
        if (!mTeams.isEmpty()) mTeams.clear();
        notifyDataSetChanged();
    }
}

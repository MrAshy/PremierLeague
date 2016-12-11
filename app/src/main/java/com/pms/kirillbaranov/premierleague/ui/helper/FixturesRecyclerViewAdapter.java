package com.pms.kirillbaranov.premierleague.ui.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Fixture;
import com.pms.kirillbaranov.premierleague.entity.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by KirillBaranov on 11.12.16.
 */

public class FixturesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Fixture> mFixtures;

    public FixturesRecyclerViewAdapter() { mFixtures = new ArrayList<>(); }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixtures_item_layout,parent,false);
        return new FixturesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FixturesItemViewHolder) holder).setContent(mFixtures.get(position));
    }

    @Override
    public int getItemCount() {
        return mFixtures.size();
    }

    public void setFixtures(Collection<Fixture> fixtures) {
        if (!mFixtures.isEmpty()) mFixtures.clear();

        mFixtures.addAll(fixtures);
        notifyDataSetChanged();
    }

    public void clear() {
        if (!mFixtures.isEmpty()) mFixtures.clear();
        notifyDataSetChanged();
    }
}

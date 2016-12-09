package com.pms.kirillbaranov.premierleague.ui.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pms.kirillbaranov.premierleague.R;
import com.pms.kirillbaranov.premierleague.entity.Standing;
import com.pms.kirillbaranov.premierleague.ui.TableLeagueItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public class TableLeagueRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Standing> mStandings;

    public TableLeagueRecycleViewAdapter() {
        mStandings = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_league_item_layout,parent,false);
        return new TableLeagueItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TableLeagueItemViewHolder) holder).setContent(mStandings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStandings.size();
    }

    public void setStandings(Collection<Standing> standings) {
        if (!mStandings.isEmpty()) mStandings.clear();

        mStandings.addAll(standings);
        notifyDataSetChanged();
    }

    public void clear() {
        if (!mStandings.isEmpty()) mStandings.clear();
        notifyDataSetChanged();
    }


}

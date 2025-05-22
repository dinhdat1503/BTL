package com.example.flashscore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashscore.R;
import com.example.flashscore.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private List<Match> matchList;

    public MatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);
        holder.tvTeams.setText(match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
        holder.tvTime.setText(match.getUtcDate());
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeams, tvTime;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeams = itemView.findViewById(R.id.tvTeams);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}

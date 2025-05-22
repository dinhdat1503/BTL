package com.example.flashscore;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.flashscore.R;
import com.example.flashscore.adapter.MatchAdapter;
import com.example.flashscore.api.ApiClient;
import com.example.flashscore.api.FootballApi;
import com.example.flashscore.model.Match;
import com.example.flashscore.model.MatchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerMatches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadMatches();

        return view;
    }

    private void loadMatches() {
        FootballApi api = ApiClient.getFootballApi();
        Call<MatchResponse> call = api.getUpcomingMatches();

        call.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {
                if (response.isSuccessful()) {
                    List<Match> matches = response.body().getMatches();
                    recyclerView.setAdapter(new MatchAdapter(matches));
                } else {
                    Toast.makeText(getContext(), "Lỗi khi tải dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

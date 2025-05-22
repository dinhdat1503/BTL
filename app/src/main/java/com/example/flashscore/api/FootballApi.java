package com.example.flashscore.api;

import com.example.flashscore.model.MatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FootballApi {
    @Headers("X-Auth-Token: d02e24cfc05e4ec4a9a015cf99951f2a")
    @GET("v4/matches")
    Call<MatchResponse> getUpcomingMatches();
}

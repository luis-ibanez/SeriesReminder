package com.luisibanez.seriesreminder.ds.movieapi.tvshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.Response;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetTvShowsResponse {

    private int page;
    private int total_pages;
    private List<TvShowMovieApi> results;

    // public constructor is necessary for collections
    public GetTvShowsResponse() {
        int nextPage;
        results = new ArrayList<TvShowMovieApi>();
    }

    public static GetTvShowsResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GetTvShowsResponse getTvShowsResponse = gson.fromJson(response, GetTvShowsResponse.class);
        return getTvShowsResponse;
    }
}

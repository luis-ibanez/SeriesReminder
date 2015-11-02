package com.luisibanez.seriesreminder.ds.movieapi.tvshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetTvShowsResponse {

    private int page;
    private int total_pages;
    private Collection<TvShowMovieApi> results;

    // public constructor is necessary for collections
    public GetTvShowsResponse() {
        results = new ArrayList<TvShowMovieApi>();
    }

    public int getNextPage() {
        return page;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public Collection<TvShowMovieApi> getTvShows() {
        return results;
    }

    public static GetTvShowsResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GetTvShowsResponse getTvShowsResponse = gson.fromJson(response, GetTvShowsResponse.class);
        return getTvShowsResponse;
    }
}

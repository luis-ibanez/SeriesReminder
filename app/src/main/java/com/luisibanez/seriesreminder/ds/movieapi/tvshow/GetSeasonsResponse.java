package com.luisibanez.seriesreminder.ds.movieapi.tvshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetSeasonsResponse {

    private int number_of_seasons;
    private List<SeasonMovieApi> seasons;

    // public constructor is necessary for collections
    public GetSeasonsResponse() {
        int number_of_seasons;
        seasons = new ArrayList<SeasonMovieApi>();
    }

    public static GetSeasonsResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GetSeasonsResponse getSeasonsResponse = gson.fromJson(response, GetSeasonsResponse.class);
        return getSeasonsResponse;
    }
}

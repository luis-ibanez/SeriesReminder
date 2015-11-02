package com.luisibanez.seriesreminder.ds.movieapi.tvshow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetChaptersResponse {

    private List<ChapterMovieApi> episodes;

    public GetChaptersResponse() {
        episodes = new ArrayList<ChapterMovieApi>();
    }

    public static GetChaptersResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GetChaptersResponse getChaptersResponse = gson.fromJson(response, GetChaptersResponse.class);
        return getChaptersResponse;
    }
}

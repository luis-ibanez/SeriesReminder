package com.luisibanez.seriesreminder.ds.movieapi;

import com.luisibanez.seriesreminder.ds.movieapi.tvshow.ChapterMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetChaptersResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetSeasonsResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetTvShowsResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.SeasonMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.TvShowMovieApi;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by libanez on 01/11/2015.
 */
public class MovieApiDataSource {

    private static final String MOVIE_API_ENDPOINT = "https://api.themoviedb.org/3/tv?api_key=966a4be6697f1d65805f13f6e25a5798";

    private MovieApiEndpointInterface apiService;

    public MovieApiDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MOVIE_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MovieApiEndpointInterface.class);
    }

    public MovieApiEndpointInterface getApiService() {
        return apiService;
    }
}

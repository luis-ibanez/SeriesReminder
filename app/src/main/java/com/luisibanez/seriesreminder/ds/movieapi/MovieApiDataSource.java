package com.luisibanez.seriesreminder.ds.movieapi;

import com.luisibanez.seriesreminder.ds.movieapi.tvshow.ChapterMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetChaptersResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetSeasonsResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetTvShowsResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.SeasonMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.TvShowMovieApi;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
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

    private static final String MOVIE_API_ENDPOINT = "https://api.themoviedb.org";

    private MovieApiEndpointInterface apiService;

    public MovieApiDataSource() {

        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);

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

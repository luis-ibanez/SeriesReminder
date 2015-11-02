package com.luisibanez.seriesreminder.ds.movieapi;

import com.luisibanez.seriesreminder.domain.GetSeasons;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetChaptersResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetSeasonsResponse;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetTvShowsResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by libanez on 01/11/2015.
 */
public interface MovieApiEndpointInterface {

    /**
     * Request method and URL specified in the annotation
     * Callback for the parsed response is the last parameter
    */
    public static String API_KEY_KEY = "api_key";
    public static String QUERY_ASSIGN = "=";
    public static String API_KEY_VALUE = "966a4be6697f1d65805f13f6e25a5798";

    @GET("/3/tv/popular?"+API_KEY_KEY+QUERY_ASSIGN+API_KEY_VALUE)
    Call<GetTvShowsResponse> getTvShows();

    @GET("/3/tv/{id}"+API_KEY_KEY+QUERY_ASSIGN+API_KEY_VALUE)
    Call<GetSeasonsResponse> getSeasons(@Path("id") String tvShowId);

    @GET("/3/tv/{id}/season/{season}"+API_KEY_KEY+QUERY_ASSIGN+API_KEY_VALUE)
    Call<GetChaptersResponse> groupList(@Path("id") String tvShowId, @Path("season") int seasonNumber);

    @GET("/tv/{id}"+API_KEY_KEY+QUERY_ASSIGN+API_KEY_VALUE)
    Call<GetTvShowsResponse> getUser(@Path("id") String tvShowId, @Query("page") int pageNumber);
}

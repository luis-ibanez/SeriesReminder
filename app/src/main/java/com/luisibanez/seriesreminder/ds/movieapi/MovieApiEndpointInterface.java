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

    @GET("/tv/popular")
    Call<GetTvShowsResponse> getTvShows();

    @GET("/tv/{id}")
    Call<GetSeasonsResponse> getSeasons(@Path("id") String tvShowId);

    @GET("/tv/{id}/season/{season}")
    Call<GetChaptersResponse> groupList(@Path("id") String tvShowId, @Path("season") int seasonNumber);

    @GET("/tv/{id}")
    Call<GetTvShowsResponse> getUser(@Path("id") String tvShowId, @Query("page") int pageNumber);
}

package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.TvShow;

import java.util.Collection;

/**
 * Returns every available TvShowMovieApi in the system.
 *
 * This interactor will not the result is the execution finish with a onConnectionError when there
 * is no internet connection and the client code executes this interactor.
 *
 * Created by libanez on 01/11/2015.
 */
public interface GetTvShows {

    interface Callback {
        void onTvShowsLoaded(int page, final Collection<TvShow> tvShows);

        void onConnectionError();
    }

    void execute(Callback callback);

    void execute(int nextPage, Callback callback);
}

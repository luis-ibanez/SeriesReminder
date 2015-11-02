package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;

import java.util.Collection;

/**
 * Get a TvShowMovieApi given a TvShowMovieApi identifier. Return the result using a Callback.
 *
 * This interactor can execute onTvShowNotFound Callback method if there is no any tv show that
 * matches with the tvShowId passed as parameter. Other possible result is the execution of
 * OnConnectionError when there is no internet connection and the client code executes this
 * interactor.
 *
 * Created by libanez on 01/11/2015.
 */

public interface GetChapters {

    interface Callback {
        void onChaptersLoaded(final Collection<Chapter> chapters);

        void onChaptersNotFound();

        void onConnectionError();
    }

    void execute(final String seriesId, final int seasonNumber, final Callback callback);
}
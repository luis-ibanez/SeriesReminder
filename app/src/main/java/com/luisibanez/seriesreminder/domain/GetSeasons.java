package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;

import java.util.Collection;

/**
 * Returns every available Seasons for a given show.
 *
 * This interactor will not the result is the execution finish with a onConnectionError when there
 * is no internet connection and the client code executes this interactor.
 *
 * Created by libanez on 01/11/2015.
 */
public interface GetSeasons {

    interface Callback {
        void onSeasonsLoaded(final Collection<Season> seasons);

        void onSeasonsNotFound();

        void onConnectionError();
    }

    void execute(final String tvShowId, final Callback callback);
}

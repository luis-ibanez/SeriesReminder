package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.Catalog;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to provide every domain dependencies as interactors or the main class of
 * this application: Catalog.
 *
 * Created by libanez on 02/11/2015.
 */

@Module(library = true, complete = false)
public final class TvShowsModule {

    @Provides
    @Singleton
    Catalog provideCatalog() {
        return new Catalog();
    }

    @Provides GetTvShows provideGetTvShowsInteractor(GetTvShowsInteractor interactor) {
        return interactor;
    }

    @Provides GetChapters provideGetChaptersInteractor(GetChaptersInteractor interactor) {
        return interactor;
    }

    @Provides GetSeasons provideGetSeasonsInteractor(GetSeasonsInteractor interactor) {
        return interactor;
    }

}
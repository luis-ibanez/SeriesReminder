package com.luisibanez.seriesreminder.ui.presenter;

import com.luisibanez.seriesreminder.ui.activity.TvShowListActivity;
import com.luisibanez.seriesreminder.ui.fragment.TvShowListFragment;

import java.util.LinkedList;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to provide TvShows UI dependencies like RendererBuilders or presenters.
 *
 * Created by libanez on 02/11/2015.
 */
@Module(complete = false,
        injects = {
                TvShowListActivity.class, TvShowListFragment.class
        }) public final class TvShowUIModule {
}

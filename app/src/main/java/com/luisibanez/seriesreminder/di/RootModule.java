package com.luisibanez.seriesreminder.di;

import android.content.Context;
import android.view.LayoutInflater;

import com.luisibanez.seriesreminder.SeriesReminderApplication;
import com.luisibanez.seriesreminder.domain.TvShowsModule;
import com.luisibanez.seriesreminder.executor.ExecutorModule;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * This module provides every application scope dependencies related with the AndroidSDK.
 *
 * Created by libanez on 02/11/2015.
 */

@Module(
        includes = {
                ExecutorModule.class, TvShowsModule.class,
        },
        injects = {
                SeriesReminderApplication.class
        }, library = true)

public final class RootModule {

    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }
}

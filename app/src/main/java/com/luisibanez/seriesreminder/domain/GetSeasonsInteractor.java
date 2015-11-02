package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.executor.Executor;
import com.luisibanez.seriesreminder.executor.Interactor;
import com.luisibanez.seriesreminder.executor.MainThread;

import java.util.Collection;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetSeasonsInteractor implements Interactor, GetSeasons {

    private final Executor executor;
    private final MainThread mainThread;

    private Callback callback;

    public GetSeasonsInteractor(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(String tvShowId, Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException(
                    "Callback can't be null, the client of this interactor needs to get the response "
                            + "in the callback");
        }
        this.callback = callback;
        this.executor.run(this);
    }

    @Override
    public void run() {

        Collection<Season> seasons = null;
        //TODO: Get seasons
        nofitySeasonsLoaded(seasons);
    }

    private void notifyError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void nofitySeasonsLoaded(final Collection<Season> seasons) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onSeasonsLoaded(seasons);
            }
        });
    }
}
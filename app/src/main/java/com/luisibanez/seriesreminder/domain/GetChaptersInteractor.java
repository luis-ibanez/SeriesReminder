package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.ChapterCollection;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.executor.Executor;
import com.luisibanez.seriesreminder.executor.Interactor;
import com.luisibanez.seriesreminder.executor.MainThread;

import java.util.Collection;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetChaptersInteractor implements Interactor, GetChapters {

    private final Executor executor;
    private final MainThread mainThread;

    private Callback callback;

    public GetChaptersInteractor(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(String seriesId, int seasonNumber, Callback callback) {
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
        Collection<Chapter> chapters = null;
        //TODO: Get chapters
        nofityChaptersLoaded(chapters);
    }

    private void notifyError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void nofityChaptersLoaded(final Collection<Chapter> chapters) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onChaptersLoaded(chapters);
            }
        });
    }
}

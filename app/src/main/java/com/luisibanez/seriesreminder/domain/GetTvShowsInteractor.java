package com.luisibanez.seriesreminder.domain;

import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.ds.movieapi.MovieApiDataSource;
import com.luisibanez.seriesreminder.ds.movieapi.MovieApiEndpointInterface;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.GetTvShowsResponse;
import com.luisibanez.seriesreminder.executor.Executor;
import com.luisibanez.seriesreminder.executor.Interactor;
import com.luisibanez.seriesreminder.executor.MainThread;

import java.util.Collection;

import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by libanez on 01/11/2015.
 */
public class GetTvShowsInteractor implements Interactor, GetTvShows {

    private final Executor executor;
    private final MainThread mainThread;

    private int page;
    private Callback callback;
    private MovieApiEndpointInterface apiService;

    public GetTvShowsInteractor(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.page = 0;
        this.apiService = new MovieApiDataSource().getApiService();
    }

    @Override
    public void execute(final Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException(
                    "Callback can't be null, the client of this interactor needs to get the response "
                            + "in the callback");
        }
        this.callback = callback;
        this.page = 1;
        this.executor.run(this);
    }

    @Override
    public void execute(final int page, final Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException(
                    "Callback can't be null, the client of this interactor needs to get the response "
                            + "in the callback");
        }
        this.callback = callback;
        this.page = page;
        this.executor.run(this);
    }

    @Override
    public void run() {
        Collection<TvShow> tvShows = null;
        Call<GetTvShowsResponse> call = apiService.getTvShows();
        call.enqueue(new retrofit.Callback<GetTvShowsResponse>() {
            @Override
            public void onResponse(Response<GetTvShowsResponse> response, Retrofit retrofit) {
                System.out.println("£$££$£$£$£$£$£$$££$££$£$£$$££$£££$£$");
                System.out.println("£$££$£$£$£$£$£$$££$££$£$£$$££$£££$£$");
                System.out.println("£$££$£$£$£$£$£$$££$££$£$£$$££$£££$£$");
                System.out.println("£$££$£$£$£$£$£$$££$££$£$£$$££$£££$£$");
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        nofityTvShowsLoaded(1, tvShows);
    }

    private void notifyError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void nofityTvShowsLoaded(final int nextPage, final Collection<TvShow> tvShows) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onTvShowsLoaded(nextPage, tvShows);
            }
        });
    }
}


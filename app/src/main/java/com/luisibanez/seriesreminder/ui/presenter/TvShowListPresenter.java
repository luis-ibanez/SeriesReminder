package com.luisibanez.seriesreminder.ui.presenter;

import com.luisibanez.seriesreminder.domain.GetChapters;
import com.luisibanez.seriesreminder.domain.GetSeasons;
import com.luisibanez.seriesreminder.domain.GetTvShows;
import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.ui.adapter.TvShowCollection;

import java.util.Collection;

/**
 * Created by libanez on 01/11/2015.
 */
public class TvShowListPresenter extends Presenter {

    private GetTvShows getTvShowsInteractor;
    private GetSeasons getSeasonsInteractor;
    private GetChapters getChaptersInteractor;

    private View view;

    private int nextPage;

    private TvShowCollection currentTvShowCollection;

    public TvShowListPresenter(GetTvShows getTvShowsInteractor) {
        this.getTvShowsInteractor = getTvShowsInteractor;
    }

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        this.view = view;
    }

    @Override
    public void initialize() {
        checkViewAlreadySetted();
        loadTvShows();
    }

    @Override
    public void resume() {
        //Empty
    }

    @Override
    public void pause() {
        //Empty
    }

    /**
     * Used to force a TvShowCollection load in the presenter. This method is used by
     * TvShowCatalogFragment when the fragment lifecycle is restored and there are already loaded tv
     * shows.
     */
    public void loadCatalog(final TvShowCollection tvShowCollection) {
        currentTvShowCollection = tvShowCollection;
        showTvShows(tvShowCollection.getAsList());
    }

    public void onTvShowClicked(final TvShow tvShow) {
        //TODO: show seasons
    }

    public void onSeasonClicked(final Season season) {
        //TODO: show chapters
    }

    public void onChapterClicked(final Chapter chapter) {
        //TODO: change seen
    }

    public TvShowCollection getCurrentTvShows() {
        return currentTvShowCollection;
    }

    /**
     * Use GetTvShows interactor to obtain a collection of videos and render it using the view
     * object setted previously. If the interactor returns an error the presenter will show an error
     * message and the empty case. In both cases, the progress bar visibility will be hidden.
     */
    private void loadTvShows() {
        if (view.isReady()) {
            view.showLoading();
        }
        getTvShowsInteractor.execute(new GetTvShows.Callback() {
            @Override
            public void onTvShowsLoaded(final int nextPage, final Collection<TvShow> tvShows) {
                currentTvShowCollection.addAll(tvShows);
                TvShowListPresenter.this.nextPage = nextPage;
                showTvShows(tvShows);
            }

            @Override
            public void onConnectionError() {
                notifyConnectionError();
            }
        });
    }

    /**
     * Use GetSeasons interactor to obtain a collection of seasons and render it using the view
     * object setted previously. If the interactor returns an error the presenter will show an error
     * message and the empty case. In both cases, the progress bar visibility will be hidden.
     */
    private void loadSeasons(final TvShow tvShow) {
        if (view.isReady()) {
            view.showLoading();
        }
        getSeasonsInteractor.execute(tvShow.getId(), new GetSeasons.Callback() {
            @Override
            public void onSeasonsLoaded(Collection<Season> seasons) {
                for(Season season : seasons) {
                    tvShow.addSeason(season);
                }
                showSeasons(seasons);
            }

            @Override
            public void onSeasonsNotFound() {

            }

            @Override
            public void onConnectionError() {
                notifyConnectionError();
            }
        });

    }

    /**
     * Use GetChapters interactor to obtain a collection of chapters and render it using the view
     * object setted previously. If the interactor returns an error the presenter will show an error
     * message and the empty case. In both cases, the progress bar visibility will be hidden.
     */
    private void loadChapters(TvShow tvshow, final Season season) {
        if (view.isReady()) {
            view.showLoading();
        }
        getChaptersInteractor.execute(tvshow.getId(), season.getNumber(), new GetChapters.Callback() {
            @Override
            public void onChaptersLoaded(Collection<Chapter> chapters) {
                for(Chapter chapter : chapters) {
                    season.addChapter(chapter);
                }
                showChapters(chapters);
            }

            @Override
            public void onChaptersNotFound() {
                //TODO: add error check
            }

            @Override
            public void onConnectionError() {
                notifyConnectionError();
            }
        });
    }

    private void notifyConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
            view.hideLoading();
            view.showConnectionErrorMessage();
            view.showEmptyCase();
            view.showDefaultTitle();
        }
    }

    private void showTvShows(Collection<TvShow> tvShows) {
        if (view.isReady()) {
            view.renderTvShows(tvShows);
            view.hideLoading();
        }
    }

    private void showSeasons(Collection<Season> seasons) {
        if (view.isReady()) {
            view.renderSeasons(seasons);
            view.hideLoading();
        }
    }

    private void showChapters(Collection<Chapter> chapters) {
        if (view.isReady()) {
            view.renderChapters(chapters);
            view.hideLoading();
        }
    }

    private void checkViewAlreadySetted() {
        if (view == null) {
            throw new IllegalArgumentException("Remember to set a view for this presenter");
        }
    }

    /**
     * View interface created to abstract the view
     * implementation used in this presenter.
     */
    public interface View {

        void hideLoading();

        void showLoading();

        void showConnectionErrorMessage();

        void showEmptyCase();

        void showDefaultTitle();

        void renderTvShows(final Collection<TvShow> tvShows);

        void renderSeasons(final Collection<Season> seasons);

        void renderChapters(final Collection<Chapter> chapters);

        boolean isReady();

        boolean isAlreadyLoaded();
    }
}


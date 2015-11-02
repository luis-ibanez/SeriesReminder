package com.luisibanez.seriesreminder.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.luisibanez.seriesreminder.R;
import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.ui.adapter.TvShowCollection;
import com.luisibanez.seriesreminder.ui.presenter.TvShowListPresenter;

import java.util.Collection;

import butterknife.InjectView;

/**
 * Fragment created to show a collection of TvShows inside a RecycleView.
 *
 * This Fragment uses a Model View Presenter implementation to implement all the presentation
 * logic. Review TvShowListPresenter to get more info about the implementation.
 *
 * This fragment is going to notify to the activity every event that has to go out of this
 * fragment. TvShowListFragmentListener is the interface declared by this fragment and
 * implemented by the activity that contains this fragment. This is a common implementation used to
 * notify user actions to the fragment owner.
 *
 * Created by libanez on 01/11/2015.
 */
public class TvShowListFragment extends BaseFragment implements TvShowListPresenter.View {

    private static final String EXTRA_TV_SHOW_CATALOG = "extra_tv_show_catalog";

    @Inject TvShowListPresenter tvShowCatalogPresenter;
    @Inject TvShowAdapterFactory tvShowRendererAdapterFactory;

    private RendererAdapter<TvShow> adapter;
    private TvShowCollection tvShows = new TvShowCollection();

    @InjectView(R.id.pb_loading)
    ProgressBar pb_loading;
    @InjectView(R.id.gv_tv_shows)
    GridView gv_tv_shows;
    @InjectView(R.id.v_empty_case)
    View v_empty_case;

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeGridView();
        tvShowCatalogPresenter.setView(this);
        tvShowCatalogPresenter.initialize();
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override public void onResume() {
        super.onResume();
        tvShowCatalogPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        tvShowCatalogPresenter.pause();
    }

    /**
     * We want to keep the catalog loaded in this fragment even if the user rotates the device. We
     * are
     * using different configurations for landscape and portrait and we have to use this approach
     * instead of onConfigurationChanges.
     */
    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_TV_SHOW_CATALOG, tvShowCatalogPresenter.getCurrentTvShows());
    }

    @Override public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            final TvShowCollection tvShowCollection =
                    (TvShowCollection) savedInstanceState.getSerializable(EXTRA_TV_SHOW_CATALOG);
            updatePresenterWithSavedTvShow(tvShowCollection);
        }
    }

    @Override public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override public void renderVideos(final Collection<TvShow> tvShows) {
        this.tvShows.clear();
        this.tvShows.addAll(tvShows);
        refreshAdapter();
    }

    @Override public void updateTitleWithCountOfTvShows(final int counter) {
        String actionBarTitle = getString(R.string.app_name_with_chapter_counter, counter);
        getActivity().setTitle(actionBarTitle);
    }

    @Override public void showConnectionErrorMessage() {
        String connectionError = getString(R.string.connection_error_message);
        ToastUtils.showShortMessage(connectionError, getActivity());
    }

    @Override public void showEmptyCase() {
        v_empty_case.setVisibility(View.VISIBLE);
    }

    @Override public void showDefaultTitle() {
        getActivity().setTitle(R.string.app_name);
    }

    @Override
    public void renderTvShows(Collection<TvShow> tvShows) {

    }

    @Override
    public void renderSeasons(Collection<Season> seasons) {

    }

    @Override
    public void renderChapters(Collection<Chapter> chapters) {

    }

    @Override public void showTvShowTitleAsMessage(TvShow tvShow) {
        ToastUtils.showShortMessage(tvShow.getTitle(), getActivity());
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public boolean isAlreadyLoaded() {
        return adapter.getCount() > 0;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_tv_show_list;
    }

    private void initializeGridView() {
        adapter = tvShowRendererAdapterFactory.getTvShowRendererAdapter(tvShows);
        gv_tv_shows.setAdapter(adapter);
    }

    private void updatePresenterWithSavedTvShow(TvShowCollection tvShowCollection) {
        if (tvShowCollection != null) {
            tvShowCatalogPresenter.loadCatalog(tvShowCollection);
        }
    }

    private void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}
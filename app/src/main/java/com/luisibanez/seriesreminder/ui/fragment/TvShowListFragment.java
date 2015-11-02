package com.luisibanez.seriesreminder.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.luisibanez.seriesreminder.R;
import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.ui.adapter.TvShowAdapter;
import com.luisibanez.seriesreminder.ui.adapter.TvShowCollection;
import com.luisibanez.seriesreminder.ui.presenter.TvShowListPresenter;
import com.luisibanez.seriesreminder.util.ToastUtils;

import java.util.Collection;

import javax.inject.Inject;

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

    private TvShowAdapter adapter;
    private TvShowCollection tvShows = new TvShowCollection();

    @Inject
    TvShowListPresenter tvShowListPresenter;

    @InjectView(R.id.tv_show_list_pb_loading)
    ProgressBar pb_loading;
    @InjectView(R.id.tv_show_rv_shows)
    RecyclerView rv_tv_shows;
    @InjectView(R.id.tv_show_list_empty_case)
    View v_empty_case;

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvShowListPresenter.setView(this);
        tvShowListPresenter.initialize();
        initializeGridView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        tvShowListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        tvShowListPresenter.pause();
    }

    /**
     * We want to keep the catalog loaded in this fragment even if the user rotates the device. We
     * are
     * using different configurations for landscape and portrait and we have to use this approach
     * instead of onConfigurationChanges.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_TV_SHOW_CATALOG, tvShowListPresenter.getCurrentTvShows());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            final TvShowCollection tvShowCollection =
                    (TvShowCollection) savedInstanceState.getSerializable(EXTRA_TV_SHOW_CATALOG);
            updatePresenterWithSavedTvShow(tvShowCollection);
        }
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
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
        this.tvShows.clear();
        this.tvShows.addAll(tvShows);
        refreshAdapter();
    }

    @Override
    public void renderSeasons(Collection<Season> seasons) {

    }

    @Override
    public void renderChapters(Collection<Chapter> chapters) {

    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public boolean isAlreadyLoaded() {
        return adapter.getItemCount() > 0;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_tv_show_list;
    }

    private void initializeGridView() {
        adapter = new TvShowAdapter(tvShowListPresenter, tvShows);
        rv_tv_shows.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_tv_shows.setAdapter(adapter);
    }

    private void updatePresenterWithSavedTvShow(TvShowCollection tvShowCollection) {
        if (tvShowCollection != null) {
            tvShowListPresenter.loadCatalog(tvShowCollection);
        }
    }

    private void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}
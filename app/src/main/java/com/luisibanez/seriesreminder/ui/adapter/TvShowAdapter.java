package com.luisibanez.seriesreminder.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisibanez.seriesreminder.R;
import com.luisibanez.seriesreminder.ui.presenter.TvShowListPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by libanez on 02/11/2015.
 */
public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private static final String TAG = TvShowAdapter.class.getName();

    private TvShowListPresenter tvShowListPresenter;
    private final TvShowCollection tvShows;

    @InjectView(R.id.tv_show_row_title) TextView titleTextView;
    @InjectView(R.id.tv_show_row_vote) TextView voteTextView;

    public TvShowAdapter(TvShowListPresenter tvShowListPresenter, TvShowCollection tvShows) {
        this.tvShowListPresenter = tvShowListPresenter;
        this.tvShows = tvShows;
    }

    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tv_show_item_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView, tvShowListPresenter);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.titleTextView.setText(tvShows.get(position).getTitle());
        viewHolder.voteTextView.setText(tvShows.get(position).getVote());
        viewHolder.itemView.setTag(R.string.tag_tv_show_id, tvShows.get(position).getId());
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @InjectView(R.id.tv_show_row_title) TextView titleTextView;
        @InjectView(R.id.tv_show_row_vote) TextView voteTextView;

        private TvShowListPresenter tvShowListPresenter;

        public ViewHolder(View itemLayoutView, TvShowListPresenter tvShowListPresenter) {
            super(itemLayoutView);
            ButterKnife.inject(this, itemLayoutView);
            itemLayoutView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            Log.d(TAG, "Click on row");
            tvShowListPresenter.onTvShowClicked((String)view.getTag(R.string.tag_tv_show_id));
        }
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tvShows.size();
    }
}

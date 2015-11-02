package com.luisibanez.seriesreminder.ui.adapter;

import com.luisibanez.seriesreminder.domain.tvshow.TvShow;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libanez on 01/11/2015.
 */
public class TvShowCollection implements AdapterCollection<TvShow>, Serializable {

    private final List<TvShow> tvShows;

    public TvShowCollection() {
        this(new LinkedList<TvShow>());
    }

    public TvShowCollection(Collection<TvShow> tvShows) {
        this.tvShows = new LinkedList<TvShow>();
        this.tvShows.addAll(tvShows);
    }

    @Override public int size() {
        return tvShows.size();
    }

    @Override public TvShow get(int index) {
        return tvShows.get(index);
    }

    @Override public void add(TvShow tvShow) {
        tvShows.add(tvShow);
    }

    @Override public void remove(TvShow tvShow) {
        tvShows.remove(tvShow);
    }

    @Override public void addAll(Collection<TvShow> tvShows) {
        this.tvShows.addAll(tvShows);
    }

    @Override public void removeAll(Collection<TvShow> tvShows) {
        this.tvShows.removeAll(tvShows);
    }

    public void clear() {
        tvShows.clear();
    }

    public List<TvShow> getAsList() {
        return (List<TvShow>) ((LinkedList<TvShow>) tvShows).clone();
    }
}

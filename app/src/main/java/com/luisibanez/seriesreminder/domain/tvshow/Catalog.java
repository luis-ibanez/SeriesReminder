package com.luisibanez.seriesreminder.domain.tvshow;

import com.luisibanez.seriesreminder.domain.exception.TvShowNotFoundException;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by libanez on 01/11/2015.
 */
public class Catalog {

    private final Set<TvShow> tvShows;

    /**
     * Default constructor. All this hardcoded information is going to be used as mocked information
     * for the demo application.
     */
    public Catalog() {
        this.tvShows = new LinkedHashSet<TvShow>();
        TvShow tvShow =
                new TvShow("1","Breaking Bad", "5");
        TvShow tvShow2 =
                new TvShow("2","Breaking Bad2", "5");
        TvShow tvShow3 =
                new TvShow("3","Breaking Bad3", "5");
        tvShows.add(tvShow);
        tvShows.add(tvShow2);
        tvShows.add(tvShow3);
    }

    /**
     * We should return a full clone of TvShowMovieApi objects inside catalog because all this data is in
     * memory and anyone can change it if we don't return only copies, but this is just a sample!
     *
     * @return all available TvShowMovieApi in the catalog.
     */
    public Collection<TvShow> getTvShows() {
        return (Set<TvShow>) ((LinkedHashSet<TvShow>) tvShows).clone();
    }

    /**
     * Search a TvShowMovieApi using a tv show identifier.
     *
     * We should return a clone of TvShowMovieApi objects inside catalog because all this data is in
     * memory and anyone can change it. But, this is just a sample!
     *
     * @param tvShowId used to search inside the catalog.
     * @return a TvShowMovieApi that matches with the parameter passed as identifier.
     * parameter.
     */
    public TvShow getTvShowById(String tvShowId) throws TvShowNotFoundException {
        TvShow result = searchTvShowById(tvShowId);
        if (result == null) {
            throw new TvShowNotFoundException(
                    "The identifier" + tvShowId + "is not associated to any TvShowMovieApi");
        }
        return result;
    }

    private TvShow searchTvShowById(String tvShowId) {
        TvShow result = null;
        for (TvShow tvShow : tvShows) {
            if (tvShow.getTitle().equals(tvShowId)) {
                result = tvShow;
                break;
            }
        }
        return result;
    }
}

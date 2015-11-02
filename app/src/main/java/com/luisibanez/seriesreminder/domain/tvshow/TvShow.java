package com.luisibanez.seriesreminder.domain.tvshow;

import java.io.Serializable;

/**
 * Contains all the information related with a TvShow.
 *
 * Id and Title fields works as TvShow identifier
 *
 * Created by libanez on 01/11/2015.
 */
public class TvShow implements Serializable {

    private final String id;
    private final String title;
    private final String vote;
    private final SeasonCollection seasons;

    public TvShow(String id, String title, String vote) {
        this.id = id;
        this.title = title;
        this.vote = vote;
        this.seasons = new SeasonCollection();
    }

    /**
     * @return the tv show id.
     */
    public String getId() {
        return title;
    }

    /**
     * @return the tv show title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the tv show vote.
     */
    public String getVote() {
        return vote;
    }

    /**
     * @return the tv show SeasonCollection.
     */
    public SeasonCollection getSeasons() {
        return seasons;
    }

    /**
     * Add a season to the tvShowViewModel.
     */
    public void addSeason(Season seasonViewModel) {
        seasons.add(seasonViewModel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TvShow)) return false;

        TvShow tvShow = (TvShow) o;

        if (!id.equals(tvShow.id) ||
                !title.equals(tvShow.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (id+title).hashCode();
    }
}

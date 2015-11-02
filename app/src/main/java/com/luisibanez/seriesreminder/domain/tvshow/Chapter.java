package com.luisibanez.seriesreminder.domain.tvshow;

import java.io.Serializable;

/**
 * Contains all the information related with a SeasonMovieApi chapter.
 *
 * Created by libanez on 01/11/2015.
 */
public class Chapter implements Serializable {

    private final String name;
    private final String overview;
    private final boolean seen;

    public Chapter(String name, String overview) {
        this.name = name;
        this.overview = overview;
        this.seen = false;
    }

    public Chapter(String name, String overview, boolean seen) {
        this.name = name;
        this.overview = overview;
        this.seen = seen;
    }

    /**
     * @return name associated to the EpisodeViewModel.
     */

    public String getName() {
        return name;
    }

    /**
     * @return overview associated to the EpisodeViewModel
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @return if the episode is already been watched associated to the EpisodeViewModel
     */
    public boolean getSeen() {
        return seen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;

        Chapter chapter = (Chapter) o;

        if (!name.equals(chapter.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

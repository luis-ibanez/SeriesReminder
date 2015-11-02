package com.luisibanez.seriesreminder.domain.tvshow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by libanez on 01/11/2015.
 */
public class SeasonCollection implements Iterable<Season>, Serializable {

    private final Set<Season> seasons;

    public SeasonCollection() {
        this.seasons = new LinkedHashSet<Season>();
    }

    public Collection<Chapter> getChapters() {
        return (Collection<Chapter>) ((LinkedHashSet<Season>) seasons).clone();
    }

    public void add(Season season) {
        this.seasons.add(season);
    }

    @Override
    public Iterator<Season> iterator() {
        return seasons.iterator();
    }
}

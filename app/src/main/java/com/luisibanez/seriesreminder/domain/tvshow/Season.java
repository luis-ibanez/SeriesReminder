package com.luisibanez.seriesreminder.domain.tvshow;

import java.io.Serializable;

/**
 * Created by libanez on 01/11/2015.
 */
public class Season implements Serializable {

    private final int number;
    private final int numChapters;
    private final ChapterCollection chapters;

    public Season(int number, int numChapters) {
        this.number = number;
        this.numChapters = numChapters;
        this.chapters = new ChapterCollection();
    }

    /**
     * @return number associated to the SeasonViewModel.
     */

    public int getNumber() {
        return number;
    }

    /**
     * @return number of chapters associated to the SeasonViewModel
     */
    public int getNumChapters() {
        return numChapters;
    }
    /**
     * Add a chapter to the seasonViewModel.
     */
    public void addChapter(Chapter chapterViewModel) {
        chapters.add(chapterViewModel);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;

        Season season = (Season) o;
        return number!=season.getNumber();
    }

    @Override
    public int hashCode() {
        return (""+number).hashCode();
    }
}

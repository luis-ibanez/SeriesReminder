package com.luisibanez.seriesreminder.ds.movieapi;

import com.luisibanez.seriesreminder.domain.tvshow.Chapter;
import com.luisibanez.seriesreminder.domain.tvshow.Season;
import com.luisibanez.seriesreminder.domain.tvshow.TvShow;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.ChapterMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.SeasonMovieApi;
import com.luisibanez.seriesreminder.ds.movieapi.tvshow.TvShowMovieApi;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by libanez on 01/11/2015.
 */
public class MovieApiMapper {
    public static TvShow getTvShowFromApiTvShow(TvShowMovieApi tvShowMovieApi) {
        return new TvShow(
                tvShowMovieApi.getId(),
                tvShowMovieApi.getName(),
                tvShowMovieApi.getVote());
    }

    public static Season getSeasonFromApiSeason(SeasonMovieApi seasonMovieApi) {
        return new Season(
                seasonMovieApi.getSeason_number(),
                seasonMovieApi.getEpisode_count()
                );
    }

    public static Chapter getChapterFromApiChapter(ChapterMovieApi chapterMovieApi) {
        return new Chapter(
                chapterMovieApi.getName(),
                chapterMovieApi.getOverview(),
                false);
    }

    public static Collection<TvShow> getTvShowsFromApiTvShows(Collection<TvShowMovieApi> tvShowsMovieApi) {

        Collection<TvShow> tvShows = new ArrayList<TvShow>();
        for(TvShowMovieApi tvShowMovieApi : tvShowsMovieApi){
            tvShows.add(getTvShowFromApiTvShow(tvShowMovieApi));
        }
        return tvShows;
    }

    public static Collection<Season> getSeasonsFromApiSeasons(Collection<SeasonMovieApi> seasonsMovieApi) {
        Collection<Season> seasons = new ArrayList<Season>();
        for(SeasonMovieApi seasonMovieApi : seasonsMovieApi){
            seasons.add(getSeasonFromApiSeason(seasonMovieApi));
        }
        return seasons;
    }

    public static Collection<Chapter> getChaptersFromApiChapters(Collection<ChapterMovieApi> chaptersMovieApi) {
        Collection<Chapter> chapters = new ArrayList<Chapter>();
        for(ChapterMovieApi chapterMovieApi : chaptersMovieApi){
            chapters.add(getChapterFromApiChapter(chapterMovieApi));
        }
        return chapters;
    }
}

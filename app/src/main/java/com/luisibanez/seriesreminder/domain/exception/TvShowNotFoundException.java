package com.luisibanez.seriesreminder.domain.exception;

/**
 * Exception throw by the application when a TvShow search can't return a valid result.
 *
 * Created by libanez on 01/11/2015.
 */
public class TvShowNotFoundException extends Exception {

    public TvShowNotFoundException() {
        super();
    }

    public TvShowNotFoundException(final String message) {
        super(message);
    }

    public TvShowNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TvShowNotFoundException(final Throwable cause) {
        super(cause);
    }
}



package com.luisibanez.seriesreminder.domain.exception;

/**
 * Exception throw by the application when a Season search can't return a valid result.
 *
 * Created by libanez on 01/11/2015.
 */
public class SeasonNotFoundException extends Exception {

    public SeasonNotFoundException() {
        super();
    }

    public SeasonNotFoundException(final String message) {
        super(message);
    }

    public SeasonNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SeasonNotFoundException(final Throwable cause) {
        super(cause);
    }
}
package com.luisibanez.seriesreminder.domain.exception;

/**
 * Exception throw by the application when a Chapter search can't return a valid result.
 *
 * Created by libanez on 01/11/2015.
 */
public class ChapterNotFoundException extends Exception {

    public ChapterNotFoundException() {
        super();
    }

    public ChapterNotFoundException(final String message) {
        super(message);
    }

    public ChapterNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ChapterNotFoundException(final Throwable cause) {
        super(cause);
    }
}
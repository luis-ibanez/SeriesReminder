package com.luisibanez.seriesreminder.executor;

/**
 * UI thread abstraction created to change the execution context from any thread to the UI thread.
 *
 * Created by libanez on 01/11/2015.
 */
public interface MainThread {
    void post(final Runnable runnable);
}

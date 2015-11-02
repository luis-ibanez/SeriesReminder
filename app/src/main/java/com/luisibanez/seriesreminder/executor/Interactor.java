package com.luisibanez.seriesreminder.executor;

/**
 * Common interface to every Interactor declared in the application. This interface represents a
 * execution unit for different use cases.
 *
 * By convention every interactor implementation will return the result using a Callback. That
 * callback should be executed over the UI thread.
 *
 * This is a simple Interactor implementation. Other approach to do this could be use a class
 * instead of an interface and create a base Interactor class that for every execution will use a
 * Request object and a callback implementation.
 *
 * Created by libanez on 01/11/2015.
 */
public interface Interactor {
    void run();
}
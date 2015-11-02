package com.luisibanez.seriesreminder.ui.adapter;

import java.util.Collection;

/**
 * Interface created to represent the adapter that store all the content to show in a Recycler list
 * view.
 *
 * Created by libanez on 01/11/2015.
 */
public interface AdapterCollection<T> {

    /**
     * @return size of the adapter collection.
     */
    int size();

    /**
     * Search an element using the index passed as argument.
     *
     * @param index to search in the collection.
     * @return the element stored at index passed as argument.
     */
    T get(int index);

    /**
     * Add a new element to the adapter collection.
     *
     * @param element to add.
     */
    void add(T element);

    /**
     * Remove one element from the adater collection.
     */
    void remove(T element);

    /**
     * Add a element collection to the adapter collection.
     *
     * @param elements to add.
     */
    void addAll(Collection<T> elements);

    /**
     * Remove a element collection to the adapter collection.
     */
    void removeAll(Collection<T> elements);
}

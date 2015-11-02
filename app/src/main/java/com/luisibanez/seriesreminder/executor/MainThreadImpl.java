package com.luisibanez.seriesreminder.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * MainThread implementation based on a Handler instantiated over the main looper obtained from
 * Looper class.
 *
 * Created by libanez on 01/11/2015.
 */
class MainThreadImpl implements MainThread {

    private Handler handler;

    MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}

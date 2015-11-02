package com.luisibanez.seriesreminder.executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to provide every dependency related with our execution service. Main
 * dependencies provided by this module are: ThreadExecutor and MainThreadImpl.
 *
 * Created by libanez on 02/11/2015.
 */
@Module(library = true)
public final class ExecutorModule {

    @Provides
    @Singleton
    Executor provideExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }
}
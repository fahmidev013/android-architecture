package com.sera.amm.common.dependencyInjection;



import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public   class BaseAppModule<T> {

    private final T mApp;

    public BaseAppModule(T app) {
        this.mApp = app;
    }

    @Provides @ApplicationScope
    public T provideApp() {
        return this.mApp;
    }


}
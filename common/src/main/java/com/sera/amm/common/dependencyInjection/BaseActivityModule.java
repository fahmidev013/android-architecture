package com.sera.amm.common.dependencyInjection;

import android.app.Activity;


import dagger.Module;
import dagger.Provides;

/**
 * Created by Reynaldi on 12/1/2016.
 */

@Module
public  class BaseActivityModule<T> {
    private final T activity;

    public BaseActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    T provideActivity() {
        return this.activity;
    }

}

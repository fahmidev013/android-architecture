package com.sera.androidarchitecture.di;

import android.app.Application;

import com.sera.amm.common.dependencyInjection.ApplicationScope;
import com.sera.amm.common.dependencyInjection.BaseAppModule;
import com.sera.androidarchitecture.IbidApp;

import app.services.LoginService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Fahmi Hakim on 02/12/2018.
 * for SERA
 */

@Module
public class AppModule extends BaseAppModule<IbidApp> {

    IbidApp mApp;

    public AppModule(IbidApp app) {
        super(app);
        this.mApp = app;
    }


    @Provides
    @ApplicationScope
    public IbidApp provideApp() {
        return this.mApp;
    }



}

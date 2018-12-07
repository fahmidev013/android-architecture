package com.sera.amm.common.module;

import android.app.Application;

import com.sera.amm.common.dagger.ApplicationScope;
import com.sera.amm.services.authInfoService.AuthInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fahmi Hakim on 03/12/2018.
 * for SERA
 */

@Module
public class AppModule {

    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides @ApplicationScope
    public Application provideApp() {
        return this.app;
    }

    @Provides @ApplicationScope
    public AuthInfo provideAuthInfo() {
        return new AuthInfo(app);
    }


}

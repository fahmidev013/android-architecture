package com.sera.amm.common.dagger;

import android.app.Application;

import com.sera.amm.common.module.AppModule;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

@ApplicationScope
@Component(modules = { AppModule.class})
public interface AppComponent {

    //-------- PROVIDE
    Application provideApp();


    void inject(Application app);
}

package com.sera.androidarchitecture.di.component;

import android.app.Activity;


import com.sera.androidarchitecture.MainActivity;
import com.sera.androidarchitecture.di.module.ActModule;
import com.sera.androidarchitecture.di.module.AppModule;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 03/12/2018.
 * for SERA
 */

@ActivityScope //dependencies = AppComponent.class,
@Component(dependencies = AppComponent.class, modules = ActModule.class)
public interface ActComponent {
    //------------- PROVIDE
    Activity provideActivity();


    AppModule.Dummy provideDummy();

    //------------- INJECT
    void inject(Activity activity);
    void inject(MainActivity activity);
}

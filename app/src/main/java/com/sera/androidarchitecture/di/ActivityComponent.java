package com.sera.androidarchitecture.di;

import android.app.Activity;

import com.sera.amm.common.dagger.ActivityScope;
import com.sera.amm.common.dagger.AppComponent;
import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;

import com.sera.androidarchitecture.pages.MainActivity;
import com.sera.androidarchitecture.pages.home.HomeActivity;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface ActivityComponent {


    void inject(HomeActivity activity);
    void inject(MainActivity activity);
    void inject(Activity activity);
}

package com.sera.androidarchitecture.di;

import com.sera.amm.common.dagger.ActivityScope;
import com.sera.amm.common.dagger.AppComponent;
import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;
import com.sera.androidarchitecture.MainActivity;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface ActivityComponent {



    void inject(MainActivity activity);
}

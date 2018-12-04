package com.sera.androidarchitecture.di.module;

import android.app.Activity;

import com.sera.androidarchitecture.MainActivity;
import com.sera.androidarchitecture.di.component.ActivityScope;
import com.sera.androidarchitecture.di.component.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fahmi Hakim on 03/12/2018.
 * for SERA
 */
@Module
public class ActModule  {
    private final Activity mActivity;

    public ActModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.mActivity;
    }



    @Provides
    @ActivityScope
    AppModule.Dummy provideDummy() {
        return new AppModule.Dummy("Sukses Inject Terusss");
    }
}

package com.sera.amm.common.module;

import android.app.Activity;

import com.sera.amm.common.dagger.ActivityScope;
import com.sera.amm.userlist.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fahmi Hakim on 03/12/2018.
 * for SERA
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    Activity provideActivity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    String provideStringApp() {
        return "Inject berhasil dari Module Common Activity";
    }

    @Provides
    @ActivityScope
    UserService provideUserService() {
        return new UserService(activity, "User service inject");
    }

}
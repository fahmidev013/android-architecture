package com.sera.androidarchitecture.di;

import android.app.Activity;

import com.google.gson.Gson;
import com.sera.amm.common.dependencyInjection.ActivityScope;
import com.sera.amm.common.dependencyInjection.BaseActivityModule;

import app.services.LoginService;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */
public class ActivityModule<T> extends BaseActivityModule<T> {

    public ActivityModule(T activity) {
        super(activity);
    }
}

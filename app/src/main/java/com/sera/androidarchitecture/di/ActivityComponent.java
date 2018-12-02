package com.sera.androidarchitecture.di;

import android.app.Activity;

import com.google.gson.Gson;
import com.sera.amm.common.dependencyInjection.ActivityScope;
import com.sera.amm.common.dependencyInjection.BaseActivityComponent;
import com.sera.amm.common.dependencyInjection.BaseActivityModule;
import com.sera.amm.common.dependencyInjection.BaseAppComponent;
import com.sera.amm.data.NetworkModule;
import com.sera.androidarchitecture.module.MainActivity;

import app.services.LoginService;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */

@ActivityScope
@Component(dependencies = BaseAppComponent.class, modules = {ActivityModule.class, NetworkModule.class})
public interface ActivityComponent<T> extends BaseActivityComponent<T> {


}

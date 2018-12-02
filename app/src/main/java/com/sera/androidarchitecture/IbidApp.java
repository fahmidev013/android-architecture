package com.sera.androidarchitecture;

import android.content.Context;
import android.content.SharedPreferences;

import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dependencyInjection.BaseAppComponent;
import com.sera.amm.common.dependencyInjection.BaseAppModule;
import com.sera.amm.data.NetworkModule;
import com.sera.androidarchitecture.di.AppComponent;
import com.sera.androidarchitecture.di.AppModule;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public class IbidApp extends BaseApp<IbidApp, AppComponent> {

    private AppComponent component;

    public IbidApp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new NetworkModule<IbidApp>(this))
                .build();
        component.inject(this);
    }


    public static IbidApp from(Context context) {
        return (IbidApp) context.getApplicationContext();
    };


    @Override
    public IbidApp getAppContext(Context context) {
        return (IbidApp) context.getApplicationContext();
    }

    @Override
    public AppComponent getDaggerComponent() {
        return this.component;
    }


    public SharedPreferences getSharedPreference(String name, int mode) {
        return this.getSharedPreferences(name, mode);
    }

    /*public Scheduler getSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }*/
}

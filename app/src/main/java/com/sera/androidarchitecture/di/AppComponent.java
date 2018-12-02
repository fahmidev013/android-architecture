package com.sera.androidarchitecture.di;

import com.google.gson.Gson;
import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dependencyInjection.ApplicationScope;
import com.sera.amm.common.dependencyInjection.BaseAppComponent;
import com.sera.amm.common.dependencyInjection.BaseAppModule;
import com.sera.amm.data.NetworkModule;
import com.sera.androidarchitecture.IbidApp;

import app.services.LoginService;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by Fahmi Hakim on 02/12/2018.
 * for SERA
 */

@ApplicationScope
@Component(modules = { BaseAppModule.class, NetworkModule.class })
public interface AppComponent extends BaseAppComponent<IbidApp>{

//    //-------- PROVIDE
//    IbidApp provideApp();

    //-------- Classes
    LoginService provideLoginService();

//    //--------- INJECT
//    void inject(IbidApp app);
//    //void inject(UnauthorisedInterceptor interceptor);
}

package com.sera.amm.common.dependencyInjection;



import dagger.Component;


/**
 * Created by Reynaldi on 12/1/2016.
 */

@ApplicationScope
@Component(modules = { BaseAppModule.class })
public interface BaseAppComponent<T> {

    //-------- PROVIDE
    T provideApp();

    //-------- Classes

//    Gson provideConstructGsonParsingDate();
//    OkHttpClient provideSecureOkHttpClient();

    //--------- INJECT
    void inject(T app);
    //void inject(UnauthorisedInterceptor interceptor);
}

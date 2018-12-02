package com.sera.amm.common.dependencyInjection;



import dagger.Component;

@ActivityScope
@Component(dependencies = BaseAppComponent.class, modules = {BaseActivityModule.class})
public interface BaseActivityComponent<T> {

    //------------- PROVIDE
    T provideActivity();



    //------------- INJECT
    void inject(T activity);

}

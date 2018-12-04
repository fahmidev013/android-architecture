package com.sera.amm.common.base;

import android.app.Application;

import com.sera.amm.common.dagger.AppComponent;
import com.sera.amm.common.module.AppModule;
import com.sera.amm.common.dagger.DaggerAppComponent;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

public abstract class BaseApp extends Application {

  private AppComponent component;

  public AppComponent component(Application app) {
    if (this.component == null) {
      this.component = DaggerAppComponent.builder()
              .appModule(new AppModule(app))
              .build();

      //this.component = getApp().component().provideActivityComponent(new ActivityModule(this));
    }
    return this.component;
  }

}

package com.sera.androidarchitecture;

import android.app.Application;
import android.content.Context;

import com.sera.androidarchitecture.di.component.AppComponent;

import com.sera.androidarchitecture.di.component.DaggerAppComponent;
import com.sera.androidarchitecture.di.module.AppModule;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public class AmmApp extends Application {
  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    setupAppComponent();
    appComponent.inject(this);
  }

  private void setupAppComponent() {
    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();
  }

  public static AmmApp getAppContext(Context context){
    return (AmmApp) context.getApplicationContext();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }

  /*@Override public <T> T makeSubComponent(Object module) {
    return DaggerHelper.makeSubComponent(appComponent, module);
  }

  @Override public void inject(Object target) {
    DaggerHelper.inject(this, target);
  }*/
}

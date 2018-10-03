package com.sera.androidarchitecture;

import android.app.Application;
import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dagger.DaggerHelper;
import com.sera.amm.data.DataModule;
import com.sera.androidarchitecture.di.component.AppComponent;
import com.sera.androidarchitecture.di.component.DaggerAppComponent;
import com.sera.androidarchitecture.di.module.AppModule;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public class AmmApp extends BaseApp {
  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    setupAppComponent();
  }

  private void setupAppComponent() {
    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .dataModule(new DataModule(BuildConfig.DEBUG))
        .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }

  @Override public <T> T makeSubComponent(Object module) {
    return DaggerHelper.makeSubComponent(appComponent, module);
  }

  @Override public void inject(Object target) {
    DaggerHelper.inject(this, target);
  }
}

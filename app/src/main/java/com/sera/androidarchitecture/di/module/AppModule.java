package com.sera.androidarchitecture.di.module;

import android.app.Application;
import android.content.Context;
import com.sera.amm.common.base.AppConfig;
import com.sera.androidarchitecture.AppConfigImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Module
public class AppModule {
  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Application provideApplication() {
    return application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return application;
  }

  @Provides
  @Singleton
  AppConfig provideAppConfig() {
    return new AppConfigImpl();
  }
}

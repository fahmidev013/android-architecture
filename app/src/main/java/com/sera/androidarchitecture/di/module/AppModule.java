package com.sera.androidarchitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.di.component.ActivityScope;
import com.sera.androidarchitecture.di.component.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Module
public class AppModule  {
  private AmmApp application;

  public AppModule(AmmApp application) {
    this.application = application;
  }

  @Provides
  @ApplicationScope
  AmmApp provideApplication() {
    return application;
  }

  @Provides
  @ApplicationScope
  Context provideApplicationContext() {
    return application;
  }


  @Provides
  @ApplicationScope
  String provideString() {
    return "Inject berhasil dari Module Application";
  }

  public static class Dummy {

    String msg;
    public Dummy(String pesan) {
      this.msg = pesan;
    }

    public String getMsg() {
      return msg;
    }
  }
  /*@Provides
  @ApplicationScope
  AppConfig provideAppConfig() {
    return new AppConfigImpl();
  }*/
}

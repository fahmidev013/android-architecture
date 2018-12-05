package com.sera.amm.common.module;


import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sera.amm.common.dagger.ActivityScope;
import com.sera.amm.data.GithubService;
import com.sera.amm.data.RallyAPI;
import com.sera.amm.userlist.RallyService;


import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Module
public class DataModule {
  private final boolean debug;
  private final Activity mActivity;

  public DataModule(boolean debug, Activity activity) {
    this.debug = debug;
    this.mActivity = activity;
  }

  @Provides
  @ActivityScope
  Gson provideGson() {
    return new GsonBuilder().create();
  }

  @Provides
  @ActivityScope
  OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build();
  }


  @Provides
  @ActivityScope
  GithubService provideGithubService(Gson gson, OkHttpClient okHttpClient) {
    return createRestService("", GithubService.class, gson, okHttpClient);
  }

    @Provides
    @ActivityScope
    RallyAPI provideRallyService(Gson gson, OkHttpClient okHttpClient) {
        return createRestService("https://rallycoding.herokuapp.com", RallyAPI.class, gson, okHttpClient);
    }


    @Provides
    @ActivityScope
    RallyService provideUserService(RallyAPI rallyAPI) {
        return new RallyService(mActivity, "User service inject", rallyAPI);
    }

  private <T> T createRestService(String baseUrl, Class<T> serviceClass, Gson gson,
      OkHttpClient okHttpClient) {
    final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

    return retrofit.create(serviceClass);
  }

  @Provides
  @ActivityScope
  DummyString provideDummyString() {
    return new DummyString("Calling from DATAMODULE");
  }

  public class DummyString {

    String msg;
    public DummyString(String pesan) {
      this.msg = pesan;
    }

    public String getMsg() {
      return msg;
    }
  }

}

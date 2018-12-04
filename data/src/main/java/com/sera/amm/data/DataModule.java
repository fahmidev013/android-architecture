package com.sera.amm.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Module
public class DataModule {
  private final boolean debug;

  public DataModule(boolean debug) {
    this.debug = debug;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    return new GsonBuilder().create();
  }

  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build();
  }

  @Provides
  @Singleton
  LoginService provideGitHubService(Gson gson, OkHttpClient okHttpClient) {
    return createRestService("", LoginService.class, gson, okHttpClient);
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
  @Singleton
  Dummy provideDummy() {
    return new Dummy("Sukses Inject Terusss");
  }

  public class Dummy {

    String msg;
    public Dummy(String pesan) {
      this.msg = pesan;
    }

    public String getMsg() {
      return msg;
    }
  }

}

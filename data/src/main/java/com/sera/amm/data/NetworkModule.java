package com.sera.amm.data;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sera.amm.common.dependencyInjection.ActivityScope;
import com.sera.amm.common.dependencyInjection.ApplicationScope;

import app.services.LoginService;
import dagger.Module;
import dagger.Provides;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Module
public class NetworkModule<T> {
  private boolean debug;

  T mApp;

  public NetworkModule(boolean debug) {
    this.debug = debug;
  }

  public NetworkModule(T mApplication) {
    this.mApp = mApplication;
  }


  @Provides
  @ApplicationScope
  Gson provideConstructGsonParsingDate() {
    return new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create();
  }

  @Provides
  @ApplicationScope
  OkHttpClient provideOkHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
    builder.readTimeout(15, TimeUnit.SECONDS);
    builder.connectTimeout(10, TimeUnit.SECONDS);
    builder.writeTimeout(10, TimeUnit.SECONDS);

    //builder.certificatePinner(new CertificatePinner.Builder().add("*.androidadvance.com", "sha256/RqzElicVPA6LkKm9HblOvNOUqWmD+4zNXcRb+WjcaAE=")
    //    .add("*.xxxxxx.com", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
    //    .add("*.xxxxxxx.com", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=")
    //    .add("*.xxxxxxx.com", "sha256/VjLZe/p3W/PJnd6lL8JVNBCGQBZynFLdZSTIqcO0SJ8=")
    //    .build());

    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      builder.addInterceptor(interceptor);
    }

    //Extra Headers

    //builder.addNetworkInterceptor().add(chain -> {
    //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
    //  return chain.proceed(request);
    //});

    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    Cache cache = new Cache(mApp.getCacheDir(), cacheSize);
    builder.cache(cache);


    return builder.build();
  }

  public static boolean isStringNullOrEmpty(String str) {
    return (str == null || str.isEmpty());
  }

  @Provides
  @ApplicationScope
  OkHttpClient provideSecureOkHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
    builder.readTimeout(15, TimeUnit.SECONDS);
    builder.connectTimeout(10, TimeUnit.SECONDS);
    builder.writeTimeout(10, TimeUnit.SECONDS);

    //builder.certificatePinner(new CertificatePinner.Builder().add("*.androidadvance.com", "sha256/RqzElicVPA6LkKm9HblOvNOUqWmD+4zNXcRb+WjcaAE=")
    //    .add("*.xxxxxx.com", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
    //    .add("*.xxxxxxx.com", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=")
    //    .add("*.xxxxxxx.com", "sha256/VjLZe/p3W/PJnd6lL8JVNBCGQBZynFLdZSTIqcO0SJ8=")
    //    .build());

    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      builder.addInterceptor(interceptor);
    }

    builder.authenticator(new Authenticator() {
      @Override
      public Request authenticate(Route route, Response response) throws IOException {
        Log.d("Http", "401 - refreshing token");

        String newAccessToken = app.component().provideAuthService().refreshToken();
        Log.d("Http", "newAccessToken Value: " + newAccessToken);

        return NetworkModule.isStringNullOrEmpty(newAccessToken)
                ? null
                : response.request().newBuilder()
                .header(AUTHORIZATION, "Bearer " + newAccessToken)
                .build();
      }
    });

    builder.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header(AUTHORIZATION, "Bearer " + mApp.getAuthInfo().getAccessToken())
                .method(original.method(), original.body())
                .build();

        return chain.proceed(request);
      }
    });

    //Extra Headers

    //builder.addNetworkInterceptor().add(chain -> {
    //  Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
    //  return chain.proceed(request);
    //});

    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    Cache cache = new Cache(app.getCacheDir(), cacheSize);
    builder.cache(cache);

    builder.addInterceptor(new UnauthorisedInterceptor(app));


    return builder.build();
  }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @ApplicationScope
    LoginService provideLoginService(Retrofit retrofit) {
        return new LoginService<T>(mApp, retrofit);
    }



  /*@Provides
  @Singleton
  BaseApiInterface provideService(Gson gson, OkHttpClient okHttpClient) {
    return createRestService("", BaseApiInterface.class, gson, okHttpClient);
  }*/


  /*private <T> T createRestService(String baseUrl, Class<T> serviceClass, Gson gson,
      OkHttpClient okHttpClient) {
    final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

    return retrofit.create(serviceClass);
  }*/
}

package app.services;

import android.app.Application;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sera.amm.common.base.BaseApp;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */
public class   BaseAPI {

        protected static Retrofit createRestService(String baseUrl, Gson gson,
                                        OkHttpClient okHttpClient) {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit;
        }
}

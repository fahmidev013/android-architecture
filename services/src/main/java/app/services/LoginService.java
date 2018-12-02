package app.services;

import android.app.Activity;
import android.app.Application;
import android.os.IBinder;

import com.google.gson.Gson;
import com.sera.amm.common.base.BaseApp;
import com.sera.amm.data.response.ResponseModel;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */
public class LoginService<T> {

    private T mApp;
    private Retrofit mRetrofit;

    @Inject
    public LoginService(T application, Retrofit retrofit) {
        this.mApp = application;
        this.mRetrofit = retrofit;

    }

    public Observable<List<ResponseModel>> getOrders(boolean includeOrderLines) {
        LoginAPI api = mRetrofit.create(LoginAPI.class);
        return api.createOrder()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Scheduler.io)
                .map(result -> result.data);
    }


}

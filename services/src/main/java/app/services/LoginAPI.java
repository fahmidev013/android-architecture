package app.services;

import android.app.Activity;
import android.app.Application;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sera.amm.data.response.ResponseModel;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */
public interface LoginAPI {

    @POST("/resources/consumers/fast-food/orders")
    Observable<ResponseModel> createOrder();

    class Factory extends BaseAPI {
        public static LoginAPI build(String url, Gson gson, OkHttpClient okHttpClient) {
            Retrofit client = createRestService("", gson, okHttpClient);
            return client.create(LoginAPI.class);
        }
    }
}

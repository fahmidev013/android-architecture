package com.sera.amm.services.authInfoService;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface AuthApi {

    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("/token")
    Observable<LoginResponse> login(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("client_id") String clientId,
                                    @Field("client_secret") String clientSecret,
                                    @Field("grant_type") String grantType);

    @POST("/resources/consumers/users/register")
    Observable<Void> register(@Body SignupModel userVM);

    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @POST("/token")
    Call<LoginResponse> refreshToken(@Field("client_id") String clientId,
                                     @Field("refresh_token") String refreshRoken,
                                     @Field("grant_type") String grantType);


}

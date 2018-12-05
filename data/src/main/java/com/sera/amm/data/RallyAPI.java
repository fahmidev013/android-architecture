package com.sera.amm.data;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.data.response.UserResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public interface RallyAPI {
    @GET("/api/music_albums")
    Observable<List<RallyResponModel>> getData();
}

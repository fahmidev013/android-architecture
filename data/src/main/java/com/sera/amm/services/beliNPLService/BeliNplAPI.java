package com.sera.amm.services.beliNPLService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public interface BeliNplAPI {
    @GET("/api/music_albums")
    Observable<List<BeliNPLResponModel>> getData();
}

package com.sera.amm.data.githubService;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public interface GithubService {
    @GET("users")
    Single<List<UserResponse>> getUsers();
}
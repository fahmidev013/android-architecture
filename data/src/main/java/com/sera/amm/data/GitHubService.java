package com.sera.amm.data;

import com.sera.amm.data.response.UserResponse;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public interface GitHubService {
  @GET("users") Single<List<UserResponse>> getUsers();
}

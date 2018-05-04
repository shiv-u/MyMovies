package com.androidexample.mymovies.api;

import com.androidexample.mymovies.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shivu on 04-04-2018.
 */

public interface Service {

    @GET("movie/popular")
    Call<MoviesResponse>getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MoviesResponse>getTopRatedMovies(@Query("api_key") String apiKey);
}

package com.example.newsnaut;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface1 {
    String BASE_URL1="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<interNews> getNews1(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );
    Call<interNews> getCategoryNews1(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );
}

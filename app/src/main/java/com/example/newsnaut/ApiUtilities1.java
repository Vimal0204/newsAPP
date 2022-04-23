package com.example.newsnaut;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities1 {
    private static Retrofit retrofit1=null;
    public static ApiInterface1 getApiInterface1()
    {
        if (retrofit1==null)
        {
            retrofit1 = new Retrofit.Builder().baseUrl(ApiInterface1.BASE_URL1).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit1.create(ApiInterface1.class);
    }
}

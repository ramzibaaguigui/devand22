package com.devfest.api.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.33.30.159:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService service = retrofit.create(ApiService.class);
}

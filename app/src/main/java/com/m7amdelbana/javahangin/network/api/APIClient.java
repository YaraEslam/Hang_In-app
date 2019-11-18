package com.m7amdelbana.javahangin.network.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public final static String BASE_URL = "https://node-hangin.herokuapp.com/api/";
    public final static String SERVICE_PLACES = BASE_URL + "places";
    public final static String SERVICE_USER_LOGIN = BASE_URL + "users/login";
    public final static String SERVICE_USER_REGISTER = BASE_URL + "users/register";

    public static Retrofit getClient(){
        if (retrofit == null){

            retrofit = new Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}

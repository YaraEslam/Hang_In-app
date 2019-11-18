package com.m7amdelbana.javahangin.network.service;

import com.m7amdelbana.javahangin.network.api.APIClient;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.m7amdelbana.javahangin.network.models.Sign_in;
import com.m7amdelbana.javahangin.network.models.Place;
import com.m7amdelbana.javahangin.network.models.Sign_up;

public interface APIInterface {

    @GET(APIClient.SERVICE_PLACES)
    Call<List< Place>> getPlaces();

    @GET(APIClient.SERVICE_PLACES + "/{id}")
    Call<Place> getPlace(@Path("id") String id,
                         @Query("pageNumber") int pageNumber,
                         @Query("pageSize") int pageSize);

    @POST(APIClient.SERVICE_USER_LOGIN)
    Call<ResponseBody> login(@Body Sign_in signIn);

    @POST(APIClient.SERVICE_USER_REGISTER)
    Call<ResponseBody> login(@Body Sign_up signUp);

}

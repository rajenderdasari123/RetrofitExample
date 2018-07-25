package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Raja on 7/22/2018.
 */

public interface Api {


    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}

package com.example.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

   Api api=retrofit.create(Api.class);
        Call<List<Hero>> call=api.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heros=response.body();
                for (Hero h : heros){
                    Log.d("name"," "+h.getName());
                    Log.d("getRealname"," "+h.getRealname());
                    Log.d("getBio"," "+h.getBio());
                    Log.d("getCreatedby"," "+h.getCreatedby());
                    Log.d("getImageurl"," "+h.getImageurl());
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });

    }
}

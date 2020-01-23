package com.example.myapplication.Retrofit;



import com.example.myapplication.Model.Example;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


public interface APIInterface {

    @GET("/v2/restaurant/?lat=37.422740&lng=-122.139956")
    Observable<List<Example>> getRestaurantsList();
}

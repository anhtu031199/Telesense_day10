package com.example.remote.api

import com.example.model.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String = "21.08785",
        @Query("lon") lon: String= "105.66642",
        @Query("units") units: String = "metric",
        @Query("APPID") app_id: String = "3b9699d496cb5bfe74fb3952c4ba5aff"
    ): Deferred<WeatherResponse>
}
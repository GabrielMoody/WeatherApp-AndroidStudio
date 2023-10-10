package com.example.weatherapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiService {

    data class MainList(
        val temp: Double,
        val humidity: Double
    )

    data class WeatherList(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )

    data class WeatherAPiResp(
        val main: MainList,
        val weather: List<WeatherList>,
        val name: String
    )

    interface WeatherService{
        @GET("weather")
        fun getWeatherData(
            @Query("q") city: String,
            @Query("appid") apiKey: String = "0889104349ef5330aa1d7667fb2af6c3",
            @Query("units") units: String = "metric"
        ): Call<WeatherAPiResp>
    }


}
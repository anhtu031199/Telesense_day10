package com.example.remote.api

class WeatherDatasource(private val weatherService: WeatherService) {
    fun getCurrentWeatherDataAsync() = weatherService.getCurrentWeatherData()
}
package com.example.detail.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.model.WeatherResponse
import com.example.repository.WeatherRepository
import com.example.repository.utils.Resource

class GetCurrentWeather(private val repository: WeatherRepository) {
    suspend operator fun invoke(forceRefresh:Boolean = false):LiveData<Resource<WeatherResponse>>{
        return  Transformations.map(repository.getCurrentWeather(forceRefresh)){
            it
        }
    }
}
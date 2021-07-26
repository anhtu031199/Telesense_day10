package com.example.repository

import androidx.lifecycle.LiveData
import com.example.model.WeatherResponse
import com.example.remote.api.WeatherDatasource
import com.example.repository.utils.NetworkBoundResource
import com.example.repository.utils.Resource
import kotlinx.coroutines.Deferred

interface WeatherRepository {
    suspend fun getCurrentWeather(forceRefresh: Boolean = false): LiveData<Resource<WeatherResponse>>
}

class WeatherRepositoryImpl(private val datasource: WeatherDatasource) : WeatherRepository {
    override suspend fun getCurrentWeather(forceRefresh: Boolean): LiveData<Resource<WeatherResponse>> {
        return object : NetworkBoundResource<WeatherResponse, WeatherResponse>() {
            override fun processResponse(response: WeatherResponse): WeatherResponse {
                return response
            }

            override suspend fun saveCallResults(items: WeatherResponse) {

            }

            override fun shouldFetch(data: WeatherResponse?): Boolean {
                return false
            }

            override suspend fun loadFromDb(): WeatherResponse? {
                return null
            }

            override fun createCallAsync(): Deferred<WeatherResponse> {
                return datasource.getCurrentWeatherDataAsync()
            }

        }.build().asLiveData()
    }

}
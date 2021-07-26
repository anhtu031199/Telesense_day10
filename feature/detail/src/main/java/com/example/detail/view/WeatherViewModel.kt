package com.example.detail.view

import androidx.core.view.KeyEventDispatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.example.common1.base.BaseViewModel
import com.example.common1.utils.Event
import com.example.detail.R
import com.example.detail.domain.GetCurrentWeather
import com.example.model.WeatherResponse
import com.example.repository.AppDispatchers
import com.example.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(
    private val getCurrentWeatherData: GetCurrentWeather,
    private val dispatcher: AppDispatchers
) :
    BaseViewModel() {
    private val _weather = MediatorLiveData<Resource<WeatherResponse>>()
    val weathers: LiveData<Resource<WeatherResponse>> get() = _weather
    private var weatherSource: LiveData<Resource<WeatherResponse>> = MutableLiveData()

    init {
        getCurrentWeather(false)
    }
    fun weatherRefreshItem() = getCurrentWeather(true)

    private fun getCurrentWeather(forceRefresh: Boolean) = viewModelScope.launch(dispatcher.main) {
        _weather.removeSource(weatherSource)
        withContext(dispatcher.io) {
            weatherSource = getCurrentWeatherData(forceRefresh = forceRefresh)
        }
        _weather.addSource(weatherSource){
            _weather.value = it
            if(it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.an_error_happened)
        }
    }

}
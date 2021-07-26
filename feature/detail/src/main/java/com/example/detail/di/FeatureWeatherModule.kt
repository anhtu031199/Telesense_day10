package com.example.detail.di

import com.example.detail.domain.GetCurrentWeather
import com.example.detail.view.WeatherViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureDetailModule = module {
    factory { GetCurrentWeather(get()) }
    viewModel { WeatherViewModel(get(), get()) }
}
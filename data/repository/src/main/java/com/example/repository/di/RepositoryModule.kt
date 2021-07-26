package com.example.repository.di

import com.example.repository.AppDispatchers
import com.example.repository.WeatherRepository
import com.example.repository.WeatherRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { WeatherRepositoryImpl(get()) as WeatherRepository}
}
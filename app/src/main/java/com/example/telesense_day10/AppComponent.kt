package com.example.telesense_day10

import com.example.repository.di.repositoryModule


import di.createRemoteModule

val appComponent = listOf(
    createRemoteModule("http://api.openweathermap.org/"),
    repositoryModule,
    featureDetailModule,
    remoteModule
)
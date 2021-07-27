package io.philippeboisney.archapp.di

import com.example.home.di.featureHomeModule
import com.example.local.di.localModule
import com.example.remote.di.createRemoteModule
import com.example.repository.di.repositoryModule
import io.philippeboisney.detail.di.featureDetailModule


val appComponent = listOf(
    createRemoteModule("http://demo9339017.mockable.io/"),
    repositoryModule,
    featureHomeModule,
    featureDetailModule,
    localModule
)
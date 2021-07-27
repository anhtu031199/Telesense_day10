package com.example.repository.di

import com.example.repository.AppDispatchers
import com.example.repository.UserRepository
import com.example.repository.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { UserRepositoryImpl(get(), get()) as UserRepository }
}
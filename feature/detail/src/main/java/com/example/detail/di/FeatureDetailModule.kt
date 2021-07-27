package io.philippeboisney.detail.di


import com.example.detail.DetailImageViewModel
import com.example.detail.DetailViewModel

import com.example.detail.domain.GetUserDetailUseCase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureDetailModule = module {
    factory { GetUserDetailUseCase(get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { DetailImageViewModel() }
}
package com.dani.catmosproto.di

import com.dani.catmosproto.BleRepository
import com.dani.catmosproto.ui.viewmodel.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module{
    single{
        BleRepository()
    }
}
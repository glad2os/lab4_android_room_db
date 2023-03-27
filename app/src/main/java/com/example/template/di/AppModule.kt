package com.example.template.di

import com.example.template.data.implementation.AirlineRepositoryImpl
import com.example.template.data.room.AppDatabase
import com.example.template.domain.repository.AirlineRepository
import com.example.template.ui.airlinedetails.AirlineDetailsViewModel
import com.example.template.ui.createentity.CreateEntityViewModel
import com.example.template.ui.showairlines.ShowAirlinesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.newInstance(androidContext()) }
    single { get<AppDatabase>().airlineDao }

    single<AirlineRepository> { AirlineRepositoryImpl(get()) }

    single { AirlineDetailsViewModel.Factory(get()) }

    viewModel { ShowAirlinesViewModel(get()) }
    viewModel { CreateEntityViewModel(get()) }
}

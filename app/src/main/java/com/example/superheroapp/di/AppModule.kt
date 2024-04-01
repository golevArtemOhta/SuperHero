package com.example.superheroapp.di

import com.example.superheroapp.presentation.Main.MainViewModel
import com.example.superheroapp.presentation.description.DescriptionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DescriptionViewModel(get()) }
}
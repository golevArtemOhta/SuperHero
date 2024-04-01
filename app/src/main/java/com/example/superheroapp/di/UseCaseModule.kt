package com.example.superheroapp.di

import com.example.superheroapp.data.GetAllHeroesUseCaseImpl
import com.example.superheroapp.data.repository.HeroesRepositoryImpl
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAllHeroesUseCase> { GetAllHeroesUseCaseImpl(get()) }

    single<HeroesRepository> { HeroesRepositoryImpl() }
}
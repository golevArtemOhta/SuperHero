package com.example.superheroapp.di

import com.example.superheroapp.data.GetAllHeroesUseCaseImpl
import com.example.superheroapp.data.GetHeroByIdUseCaseImpl
import com.example.superheroapp.data.repository.HeroesRepositoryImpl
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import com.example.superheroapp.domain.usecase.GetHeroByIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAllHeroesUseCase> { GetAllHeroesUseCaseImpl(get()) }
    factory<GetHeroByIdUseCase> { GetHeroByIdUseCaseImpl(get()) }

    single<HeroesRepository> { HeroesRepositoryImpl() }
}
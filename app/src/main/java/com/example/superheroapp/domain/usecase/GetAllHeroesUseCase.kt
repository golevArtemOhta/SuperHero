package com.example.superheroapp.domain.usecase

import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository

interface GetAllHeroesUseCase {

    suspend fun getAllHeroesUseCase(): List<HeroItem>?
}
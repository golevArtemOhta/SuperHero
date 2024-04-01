package com.example.superheroapp.domain.repository

import com.example.superheroapp.domain.model.HeroItem

interface HeroesRepository {

    suspend fun getAllHeroesUseCase(): List<HeroItem>?

}
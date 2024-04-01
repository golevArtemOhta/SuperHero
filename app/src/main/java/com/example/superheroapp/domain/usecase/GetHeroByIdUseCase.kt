package com.example.superheroapp.domain.usecase

import com.example.superheroapp.domain.model.HeroItem

interface GetHeroByIdUseCase {

    suspend fun getHeroByIdUseCase(id: Int): HeroItem?
}
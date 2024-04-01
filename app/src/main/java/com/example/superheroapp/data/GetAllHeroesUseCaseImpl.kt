package com.example.superheroapp.data

import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase

class GetAllHeroesUseCaseImpl(private val repository: HeroesRepository) : GetAllHeroesUseCase {

    override suspend fun getAllHeroesUseCase(): List<HeroItem>? {
        return repository.getAllHeroesUseCase()
    }
}
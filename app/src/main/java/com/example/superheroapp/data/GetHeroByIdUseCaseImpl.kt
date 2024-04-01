package com.example.superheroapp.data

import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetHeroByIdUseCase

class GetHeroByIdUseCaseImpl(private val repository: HeroesRepository): GetHeroByIdUseCase {
    override suspend fun getHeroByIdUseCase(id: Int): HeroItem? {
        return repository.getHeroByIdUseCase(id)
    }


}
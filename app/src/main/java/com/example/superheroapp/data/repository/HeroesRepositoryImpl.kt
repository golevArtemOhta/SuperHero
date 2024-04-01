package com.example.superheroapp.data.repository

import com.example.superheroapp.data.network.RetrofitFactory
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository

class HeroesRepositoryImpl : HeroesRepository {

    private val api = RetrofitFactory.new()
    override suspend fun getAllHeroesUseCase(): List<HeroItem>? {
        val response = api.getSuperHeroes()
        return response.body()
    }

    override suspend fun getHeroByIdUseCase(id: Int): HeroItem? {
        val response = api.getSuperHeroes()
        val hero = response.body()?.get(id)
        return hero
    }
}
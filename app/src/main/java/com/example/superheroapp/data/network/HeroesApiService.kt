package com.example.superheroapp.data.network

import com.example.superheroapp.domain.model.HeroItem
import retrofit2.Response
import retrofit2.http.GET

interface HeroesApiService {

    @GET("/api/heroStats")
    suspend fun getSuperHeroes(): Response<List<HeroItem>>
}
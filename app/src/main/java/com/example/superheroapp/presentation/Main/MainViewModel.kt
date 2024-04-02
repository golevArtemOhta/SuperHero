package com.example.superheroapp.presentation.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getAllHeroesUseCase: GetAllHeroesUseCase): ViewModel() {

    private val _heroesList = MutableLiveData<List<HeroItem>>()
    val heroesList: LiveData<List<HeroItem>>
        get() = _heroesList

    fun getHeroesList(){
        viewModelScope.launch(Dispatchers.IO) {
            _heroesList.postValue(getAllHeroesUseCase.getAllHeroesUseCase())
        }
    }

}
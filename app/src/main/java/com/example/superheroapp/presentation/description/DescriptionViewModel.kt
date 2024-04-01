package com.example.superheroapp.presentation.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import com.example.superheroapp.domain.usecase.GetHeroByIdUseCase
import kotlinx.coroutines.launch

class DescriptionViewModel(private val getHeroByIdUseCase: GetHeroByIdUseCase): ViewModel() {

    private val _hero = MutableLiveData<HeroItem>()
    val hero: LiveData<HeroItem>
        get() = _hero

    fun getHeroById(id:Int){
        viewModelScope.launch {
            _hero.postValue(getHeroByIdUseCase.getHeroByIdUseCase(id))
        }
    }
}
package com.example.superheroapp.presentation.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import com.example.superheroapp.domain.usecase.GetHeroByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DescriptionViewModel(private val getHeroByIdUseCase: GetHeroByIdUseCase): ViewModel() {

    data class UIStateHero(val hero: HeroItem? = null, val error: String? = null)
    private val _hero = MutableStateFlow<UIStateHero>(UIStateHero())
    val hero: StateFlow<UIStateHero>
        get() = _hero

    fun getHeroById(id:Int){
        viewModelScope.launch {

            getHeroByIdUseCase.getHeroByIdUseCase(id).let { hero ->
                _hero.update { it.copy(hero) }
            }
        }
    }
}
package com.example.superheroapp.presentation.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.domain.repository.HeroesRepository
import com.example.superheroapp.domain.usecase.GetAllHeroesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val getAllHeroesUseCase: GetAllHeroesUseCase): ViewModel() {

    data class UIState(val heroesList: List<HeroItem> = emptyList(), val error: String? = null)

    private val _heroesList = MutableStateFlow<UIState>(UIState())
    val heroesList: StateFlow<UIState>
        get() = _heroesList

    init {
        getHeroesList()
    }
    private fun getHeroesList(){
        viewModelScope.launch(Dispatchers.IO) {
            getAllHeroesUseCase.getAllHeroesUseCase()?.let { list ->
                _heroesList.update { it.copy(list) }
            }

        }
    }

}
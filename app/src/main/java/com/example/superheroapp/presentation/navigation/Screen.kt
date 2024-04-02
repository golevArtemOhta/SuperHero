package com.example.superheroapp.presentation.navigation

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object DescriptionScreen: Screen("description_screen")
}

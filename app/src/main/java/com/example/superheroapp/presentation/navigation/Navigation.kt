package com.example.superheroapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superheroapp.presentation.Main.MainScreen
import com.example.superheroapp.presentation.description.DescriptionScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = "${Screen.DescriptionScreen.route}/{idHero}",
            arguments = listOf(navArgument("idHero") { type = NavType.IntType })
        ) { entry ->
            DescriptionScreen(
                idHero = entry.arguments?.getInt("idHero"),
                navController = navController
            )
        }
    }
}
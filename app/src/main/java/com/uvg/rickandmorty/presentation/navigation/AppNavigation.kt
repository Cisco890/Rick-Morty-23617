package com.uvg.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.rickandmorty.presentation.BottomNavigationBar
import com.uvg.rickandmorty.presentation.login.LoginScreen
import com.uvg.rickandmorty.presentation.profile.ProfileScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable(route = "login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("characters") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }



    }

    val currentRoute = navController.currentBackStackEntry?.destination?.route
    if (currentRoute != "login") {
        BottomNavigationBar(navController = navController)
    }
}

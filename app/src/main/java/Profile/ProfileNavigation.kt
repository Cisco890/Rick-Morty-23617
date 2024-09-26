package com.uvg.rickandmorty.presentation.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(ProfileDestination, navOptions)
}

fun NavGraphBuilder.profileScreen(
    onLogoutClick: () -> Unit,
    navController: NavController
) {
    composable<ProfileDestination> {
        ProfileRoute(
            navController = navController,
            onLogoutClick = onLogoutClick
        )
    }
}

package com.uvg.rickandmorty.presentation.location

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.uvg.rickandmorty.presentation.location.list.LocationsListDestination
import com.uvg.rickandmorty.presentation.location.list.locationsListScreen
import com.uvg.rickandmorty.presentation.location.details.locationDetailsScreen
import com.uvg.rickandmorty.presentation.location.details.navigateToLocationDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data object LocationsNavGraph

fun NavController.navigateToLocationsGraph(navOptions: NavOptions? = null) {
    this.navigate(LocationsNavGraph, navOptions)
}

fun NavGraphBuilder.locationsGraph(
    navController: NavController
) {
    navigation<LocationsNavGraph>(
        startDestination = LocationsListDestination
    ) {
        locationsListScreen(
            onLocationClick = navController::navigateToLocationDetailsScreen
        )
        locationDetailsScreen(
            onNavigateBack = navController::navigateUp
        )
    }
}


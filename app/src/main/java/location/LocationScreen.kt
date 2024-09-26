package com.uvg.rickandmorty.presentation.location.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.rickandmorty.data.model.Location
import com.uvg.rickandmorty.data.source.LocationDb
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme
import kotlinx.serialization.Serializable


@Serializable
data object LocationsListDestination

fun NavGraphBuilder.locationsListScreen(
    onLocationClick: (Int) -> Unit
) {
    composable<LocationsListDestination> {
        LocationsListRoute(onLocationClick = onLocationClick)
    }
}
@Composable
fun LocationsListRoute(
    onLocationClick: (Int) -> Unit,
) {
    val locationDb = LocationDb()
    val locations = locationDb.getAllLocations()
    LocationsListScreen(
        locations = locations,
        onLocationClick = onLocationClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun LocationsListScreen(
    locations: List<Location>,
    onLocationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(locations) { item ->
            LocationItem(
                location = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLocationClick(item.id) }
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun LocationItem(
    location: Location,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = location.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = location.type, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview
@Composable
fun PreviewLocationsListScreen() {
    RickAndMortyTheme {
        LocationsListScreen(
            locations = listOf(
                Location(1, "Earth (C-137)", "Planet", "Dimension C-137"),
                Location(2, "Citadel of Ricks", "Space station", "Dimension C-137")
            ),
            onLocationClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

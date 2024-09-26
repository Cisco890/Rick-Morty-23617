package com.uvg.rickandmorty.presentation.location.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.rickandmorty.data.model.Location
import com.uvg.rickandmorty.data.source.LocationDb
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme

@Composable
fun LocationDetailsRoute(
    id: Int,
    onNavigateBack: () -> Unit
) {
    val locationDb = LocationDb()
    val location = locationDb.getLocationById(id)
    LocationDetailsScreen(
        location = location,
        onNavigateBack = onNavigateBack,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetailsScreen(
    location: Location,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        TopAppBar(
            title = {
                Text("Location Details")
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "ID: ${location.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Name: ${location.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Type: ${location.type}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Dimension: ${location.dimension}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLocationDetailsScreen() {
    RickAndMortyTheme {
        Surface {
            LocationDetailsScreen(
                location = Location(1, "Earth (C-137)", "Planet", "Dimension C-137"),
                onNavigateBack = {},
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

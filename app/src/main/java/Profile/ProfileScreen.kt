package com.uvg.rickandmorty.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.rickandmorty.R

@Composable
fun ProfileRoute(
    navController: NavController,
    onLogoutClick: () -> Unit
) {
    ProfileScreen(
        navController = navController,
        onLogoutClick = onLogoutClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun ProfileScreen(
    navController: NavController,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image and Details
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cisco),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(120.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )

            Text(text = "Nombre: Juan Francisco Martínez", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Carnet: 23617", style = MaterialTheme.typography.bodyLarge)
        }

        // Logout Button
        Button(
            onClick = {
                navController.navigate("login_route") {
                    popUpTo(0) // Clear the backstack
                }
                onLogoutClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cerrar sesión")
        }
    }
}

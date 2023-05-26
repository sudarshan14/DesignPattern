package com.amlavati.designpatterns.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.amlavati.designpatterns.R
import com.amlavati.designpatterns.naviation.Destination

@Composable
fun Profile(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = stringResource(id = R.string.profile_screen))
        Button(onClick = {
            navController.navigate(Destination.Home.route) {

            }
        }) {
            Text(text = "Go to Home")
        }

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Backstack button")
        }


    }
}
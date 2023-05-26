package com.amlavati.designpatterns

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.amlavati.designpatterns.naviation.Destination

@Composable
fun BottomNavigation(navController: NavController) {
    NavigationBar(

    ) {

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        NavigationBarItem(
            selected = currentDestination?.route == Destination.Home.route,
            onClick = {
                navController.navigate(Destination.Home.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Home",
                )
            },
            label = {
                Text(
                    text = Destination.Home.route,
                    fontWeight = FontWeight.SemiBold,
                )
            })
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Feed.route,
            onClick = {
                navController.navigate(Destination.Feed.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Home",
                )
            },
            label = {
                Text(
                    text = Destination.Feed.route,
                )

            })
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Profile.route,
            onClick = {
                navController.navigate(Destination.Profile.route)
            },
            icon = {
                Icon(imageVector = Icons.Rounded.Person, contentDescription = null)
            },
            label = {
                Text(text = Destination.Profile.route)

            })
    }
}
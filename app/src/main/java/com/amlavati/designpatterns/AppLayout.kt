package com.amlavati.designpatterns

import DetailScreen
import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.amlavati.designpatterns.features.feed.Feed
import com.amlavati.designpatterns.features.home.Home
import com.amlavati.designpatterns.features.list.ListScreen
import com.amlavati.designpatterns.features.profile.Profile
import com.amlavati.designpatterns.naviation.Destination
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppLayout(navController: NavHostController, drawerState: DrawerState) {
    // val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
        topBar = {
            TopAppBar(
                title = { Text(text = "App") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {

        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) {
                Home(navController = navController)
            }

            composable(Destination.Feed.route) {
                Feed(navController)
            }

            composable(Destination.Profile.route) {
                Profile(navController)
            }
            composable(Destination.List.route) {
                ListScreen(navController)
            }
            composable(Destination.Detail.route) {
                val userId = it.arguments?.getString("userId")
                userId?.let { id ->
                    DetailScreen(navController, id.toInt())
                }

            }
        }

    }
}
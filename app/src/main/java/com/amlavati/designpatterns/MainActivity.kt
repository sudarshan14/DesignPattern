package com.amlavati.designpatterns

import DetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.amlavati.designpatterns.features.feed.Feed
import com.amlavati.designpatterns.features.home.Home
import com.amlavati.designpatterns.features.list.ListScreen
import com.amlavati.designpatterns.features.profile.Profile
import com.amlavati.designpatterns.naviation.Destination
import com.amlavati.designpatterns.ui.theme.DesignPatternsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignPatternsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val nav = rememberNavController()
//                    Navigation(navController = nav)
//                    AppLayout(navController = nav)
                    AppRoot(navController = nav)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {

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

        composable(Destination.List.route  ) {
            ListScreen(navController)
        }

        composable(Destination.Detail.route,
            deepLinks = listOf(navDeepLink { uriPattern ="https://www.amlavati.com/{userId}" })
        ) {
            val userId = it.arguments?.getString("userId")
            userId?.let { id ->
                DetailScreen(navController, id.toInt())
            }

        }

    }


}







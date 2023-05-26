package com.amlavati.designpatterns.naviation

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Feed : Destination("feed")
    object Profile : Destination("profile")
    object List : Destination("list")
    object Detail : Destination("detail/{userId}") {
        fun createRoute(userId: Int) = "detail/$userId"
    }
}

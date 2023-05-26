package com.amlavati.designpatterns.features.home

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.amlavati.designpatterns.R
import com.amlavati.designpatterns.naviation.Destination

@Composable
fun Home(navController: NavController) {

    val scrollState = rememberScrollState()

    var color1 = Color(android.graphics.Color.parseColor("#000000"))
    var color2 = Color(android.graphics.Color.parseColor("#AAAAAA"))

    val colorStops = arrayOf(
        0.8f to color1,
        0.2f to color2,
    )

//    var brush = Brush.verticalGradient(listOf(color1, color2), startY = .8f, endY = .2f)
    var brush = Brush.verticalGradient(colorStops = colorStops)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = stringResource(id = R.string.home_screen))
        color1 = Color(android.graphics.Color.parseColor("#EEEEEE"))
        color2 = Color(android.graphics.Color.parseColor("#EEEEEE"))
        brush = Brush.linearGradient(listOf(color1, color2))

        Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.background(brush),
            onClick = {
                navController.navigate(Destination.Feed.route)
            }) {
            Text(text = "Feed", color = Color.Black)
        }

        color1 = Color(android.graphics.Color.parseColor("#35A9F1"))
        val color3 = Color(android.graphics.Color.parseColor("#35A9F1"))
        val color4 = Color(android.graphics.Color.parseColor("#35A9F1"))
        color2 = Color(android.graphics.Color.parseColor("#EEEEEE"))
        brush = Brush.linearGradient(listOf(color1, color3, color4, color2))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.background(brush),
            onClick = {
                navController.navigate(Destination.Profile.route)
            }) {
            Text(text = "Profile")
        }

        Button(onClick = {
            navController.navigate(Destination.List.route)
        }) {


            Text(text = "Show List")
        }
        val ctx = LocalContext.current
        Button(onClick = {
            val intent = Intent(ctx, com.amlavati.tictactoe.TicTacToeActivity::class.java)
            ctx.startActivity(intent)
        }) {
            Text(text = "Play Tick Tac Toe")
        }

        Button(onClick = {
            val intent = Intent(ctx, com.amlavati.photopicker.PhotoPicker::class.java)
            ctx.startActivity(intent)
        }) {
            Text(text = "Photo Editor")
        }

        Button(onClick = {
            val intent = Intent(ctx, com.amlavati.photopicker.PhotoPicker::class.java)
            ctx.startActivity(intent)
        }) {
            Text(text = "Pokédex")
        }
    }
}

fun method(i: Int) {

}

fun method(i: Double) {

}
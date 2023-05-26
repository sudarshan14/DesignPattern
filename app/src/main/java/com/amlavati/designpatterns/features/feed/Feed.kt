package com.amlavati.designpatterns.features.feed

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amlavati.designpatterns.R
import com.amlavati.designpatterns.naviation.Destination

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Feed(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = stringResource(id = R.string.feed_screen))
        Button(onClick = {
            navController.navigate(Destination.Profile.route) {
                popUpTo(Destination.Home.route)
            }
        }) {
            Text(text = "Go to Profile")
        }
        Canvas(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        ) {
            drawCircle(
                color = Color.Red,
                radius = 213f,
            )
        }
        class GridItem(
            val id: Int,
            val color: Color,
            val size: Dp
        )

        val itemss: List<GridItem> = listOf(
            GridItem(1, Color.Red, 100.dp),
            GridItem(1, Color.Blue, 150.dp),
            GridItem(1, Color.Black, 200.dp),
            GridItem(1, Color.Magenta, 100.dp),
            GridItem(1, Color.Cyan, 200.dp)
        )
        LazyVerticalGrid(
//                modifier = Modifier,
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),//16.dp

        ) {
            itemsIndexed(itemss) { index, item ->

                Box(
                    modifier = Modifier
                        .background(item.color)
                        .height(item.size)
                )
            }
        }


    }
}
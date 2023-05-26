package com.amlavati.designpatterns.features.list

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amlavati.designpatterns.R
import com.amlavati.designpatterns.data.User
import com.amlavati.designpatterns.naviation.Destination
import com.amlavati.designpatterns.ui.theme.listBackground

@Composable
fun ListScreen(navController: NavController) {

    val users = User.getTestList()
    val collapsedHeight = 100
    val expandedHeight = 200
    val height = remember { mutableStateOf(collapsedHeight) }
    val expandedState = remember { mutableStateListOf<Int>() }
    users.forEach {
        expandedState.add(collapsedHeight)
    }
    val isExpanded = remember { mutableStateOf(false) }
    LazyColumn {
        itemsIndexed(users) { index, item ->
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.dp_8))
                    .clickable {

                        if (isExpanded.value) {
                            expandedState[index] = collapsedHeight

                        } else {
                            expandedState[index] = expandedHeight
                        }
                        isExpanded.value = !isExpanded.value
                        val route = Destination.Detail.createRoute(item.id)
                        navController.navigate(route)
                    }
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)))
                    .fillMaxWidth()
                    .background(listBackground)
                    .padding(dimensionResource(id = R.dimen.dp_8))

            ) {
                Column(
                    modifier = Modifier.height(expandedState[index].dp)
                ) {
                    Text(text = item.name, fontWeight = FontWeight.Bold)
                    Text(text = item.surname)
                }


            }
        }
    }

}

@Preview
@Composable
fun Preview() {
    ListScreen(navController = NavController(LocalContext.current))
}
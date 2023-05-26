package com.amlavati.designpatterns

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.amlavati.designpatterns.naviation.Destination
import kotlinx.coroutines.launch

@Composable
fun AppRoot(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
// icons to mimic drawer destinations
    val items = listOf(Icons.Default.Home, Icons.Default.List, Icons.Default.Person)
    val destination = listOf(Destination.Home.route, Destination.Feed.route, Destination.Profile.route)
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
           ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.withIndex().forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.value, contentDescription = null) },
                        label = { Text(item.value.name) },
                        selected = item.value == selectedItem.value,
                        onClick = {
                            navController.navigate(destination[item.index])
                            scope.launch { drawerState.close() }
                            selectedItem.value = item.value
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }) {
        AppLayout(navController, drawerState)
    }
}
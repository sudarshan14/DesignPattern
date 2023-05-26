package com.amlavati.designpatterns.features.clickcounter

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.amlavati.designpatterns.R
import com.amlavati.designpatterns.commonutil.printDebugLog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ClickCounter(
    counter: Int,
    count: Int,
    counting: Int,
    navController: NavController,
    onClick: () -> Unit
) {

    printDebugLog(message = "click counter")
    val openGame = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        printDebugLog(message = "column")
        Button(onClick = onClick) {
            printDebugLog(message = "Button")
            Text(text = "$counter")
            Text(text = "$count")
            Text(text = "$counting")
        }

        Button(onClick = {
            navController.navigate("hello")
            //  openGame.value = true
        }) {
            printDebugLog(message = "Button2")
            Text(text = stringResource(id = R.string.app_name))
        }

        //   Image(painter = painterResource(id = R.drawable.d4logo), contentDescription = "")


    }


}


@Composable
fun TestSideEffect() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val showProgress = remember { mutableStateOf(false) }
        val launchEffect = remember { mutableStateOf(false) }
        val context = LocalContext.current

        Button(onClick = {
            showProgress.value = true
            launchEffect.value = true
        }) {

            Text(text = "Start Processing")
        }
        if (showProgress.value)
            CircularProgressIndicator()

        if (launchEffect.value) {
            val coroutineScope = rememberCoroutineScope()
            LaunchedEffect(key1 = Unit) {
                coroutineScope.launch {
                    delay(3000)
                    Toast.makeText(context, "Task Completed", Toast.LENGTH_SHORT)
                        .show()

                    showProgress.value = false
                    launchEffect.value = false
                }
            }
        }
    }
}
//      ClickCounter(counter, count.value, counting, navController, onClick)
//val count = rememberSaveable() {
//    mutableStateOf(0)
//}


//val (counter, setCounter) = androidx.compose.runtime.remember {
//    androidx.compose.runtime.mutableStateOf(0)
//}
//
//var counting by rememberSaveable {
//    mutableStateOf(0)
//}
//
//val onClick = {
//    setCounter(counter + 1)
//    count.value += 1
//    counting += 1
//
//}
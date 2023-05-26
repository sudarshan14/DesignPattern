package com.amlavati.designpatterns

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import com.amlavati.designpatterns.commonutil.INPUT_STRING_2
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject


const val TAG = "DesignTokens"
@Composable
fun DemoComposable() {

    var convertedArray: JsonArray? = null
    runCatching {
        val string: String = INPUT_STRING_2
        convertedArray = Gson().fromJson(string, JsonArray::class.java)
    }.onFailure {
        Toast.makeText(LocalContext.current, "$it", Toast.LENGTH_LONG).show()
    }.onSuccess {
        for (item in convertedArray!!) {

            Log.d(TAG, "DemoComposable: $item")
            CreateComposableElement(item)
        }
    }

}


@Composable
fun CreateComposableElement(item: JsonElement) {

    runCatching {

        val type = (item as JsonObject).get("type").asString


        when (type) {
            "Image" -> {
                AsyncImage(
                    model = item.get("url").asString,
                    contentDescription = ""
                )
            }

            "TextField" -> {
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = item.get("placeholder").asString) }
                )
            }

            "Button" -> {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = item.get("background-color").asString.getColor()
                    )
                ) {
                    Text(text = item.get("label").asString)
                }
            }
        }
    }.onFailure {
        Log.e(TAG, "CreateComposableElement: $it")
    }
}


fun String.getColor(): Color {

    return when (this) {
        "Red" -> Color.Red
        "Blue" -> Color.Blue
        else -> {
            Color.Yellow
        }
    }
}




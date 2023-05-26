package com.amlavati.photopicker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


import com.amlavati.photopicker.ui.theme.DesignPatternsTheme

class EditActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignPatternsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var uriString: String?
                    uriString = intent.extras?.getString("imageUri")
                    if (uriString == null)
                        uriString = intent.extras?.get(Intent.EXTRA_STREAM).toString()


                    val currentTool = remember { mutableStateOf<TOOL?>(null) }
                    val brightness = remember { mutableStateOf(0f) }
                    val saturation = remember { mutableStateOf(1f) }

                    val tool = listOf(
                        ToolButton(
                            TOOL.BRIGHTNESS,
                            {
                                Log.d("TAG", "onClick brightness ")
                                currentTool.value = TOOL.BRIGHTNESS
                            },
                            R.drawable.ic_bright
                        ),
                        ToolButton(
                            TOOL.SATURATION,
                            { currentTool.value = TOOL.SATURATION },
                            R.drawable.ic_saturation
                        )
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        ToolHeader(list = tool, currentTool = currentTool)
                        DisplayImage(uriString, brightness.value, saturation.value)

                        when (currentTool.value) {
                            TOOL.BRIGHTNESS -> ToolBrightness(brightness = brightness)
                            TOOL.SATURATION -> ToolSaturation(saturation = saturation)
                            else -> {}
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun ToolHeader(list: List<ToolButton>, currentTool: MutableState<TOOL?>) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        items(list) {
            val icon = painterResource(id = it.icon)
            IconButton(
                onClick = it.onClick,
                modifier = Modifier
                    .padding(4.dp)
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (currentTool.value == it.tool) {
                            Log.d("TAG", "currentTool.value: if ${currentTool.value} ")
                            MaterialTheme.colorScheme.secondary
                        } else {
                            Log.d("TAG", "currentTool.value:else ${currentTool.value} ")
                            Color.White
                        }
                    )
                    .padding(4.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(painter = icon, contentDescription = null)
                    Text(text = it.tool.name, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun DisplayImage(uriString: String, brightness: Float, saturation: Float) {

    val uri = Uri.parse(uriString)

    val matrixFilter = ColorMatrix()
    matrixFilter.setToSaturation(saturation)
    matrixFilter[0, 4] = brightness
    matrixFilter[1, 4] = brightness
    matrixFilter[2, 4] = brightness

    val painter = rememberAsyncImagePainter(model = uri)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painter, contentDescription = null,
            colorFilter = ColorFilter.colorMatrix(matrixFilter)
        )

    }
}

@Composable
fun ToolBrightness(brightness: MutableState<Float>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Brightness")
        Slider(
            valueRange = -225f..225f,
            value = brightness.value,
            onValueChange = {
                brightness.value = it
            })
    }
}

@Composable
fun ToolSaturation(saturation: MutableState<Float>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Saturation")
        Slider(
            valueRange = -0f..5f,
            value = saturation.value,
            onValueChange = {
                saturation.value = it
            })

    }
}
package com.amlavati.designpatterns.commonutil

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGradientBackground(styles: List<Color>): Brush? {

    var gradient: Brush? = null

    if (styles.size > 1) {
        val list = mutableListOf<Color>()
        for (color in styles) {
            list.add(color)
        }
//        gradient =
//            if (styles.gradientStartAlignment == "Top" && styles.gradientEndAlignment == "Bottom") {
//                Brush.verticalGradient(list.toList())
//            } else if (styles.gradientStartAlignment == "Right" && styles.gradientEndAlignment == "Left") {
//                Brush.horizontalGradient(list.reversed().toList())
//            } else if (styles.gradientStartAlignment == "TopLeft" && styles.gradientEndAlignment == "BottomRight") {
//                Brush.linearGradient(listOf(Color.Red, Color.Yellow, Color.Blue))
//            } else if (styles.gradientStartAlignment == "Left" && styles.gradientEndAlignment == "Left") {
//                Brush.horizontalGradient(list.toList())
//            } else {
//                Brush.horizontalGradient(list.toList())
//            }
    }

    return gradient
}
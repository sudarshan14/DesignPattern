package com.amlavati.photopicker

enum class TOOL(name:String){
    BRIGHTNESS("Brightness"),
    SATURATION("Saturation")
}

data class ToolButton(
    val tool:TOOL,
    val onClick:() ->Unit,
    val icon:Int = 0
)

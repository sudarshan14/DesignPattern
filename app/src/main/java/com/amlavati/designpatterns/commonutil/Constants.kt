package com.amlavati.designpatterns.commonutil

import androidx.compose.runtime.MutableState

const val INPUT_STRING = "[ \n" +
        "\n" +
        "{ \"type\": \"Image\", \"url\": \"https://www.logolynx.com/images/logolynx/a4/a4a6d38594495045fe4a52f6ebb4551b.png\" },\n" +
        "\n" +
        " { \"type\": \"TextField\", \"placeholder\": \"username\" },\n" +
        "\n" +
        " { \"type\": \"TextField\", \"placeholder\": \"password\" }," +
        " { \"type\": \"Button\", \"label\": \"Submit\", \"background-color\": \"Red\" } \n" +
        "\n" +
        "]"


data class ScreenJsonStringHolder(var held: MutableState<String>)


const val INPUT_STRING_2 = "[\n" +
        "\n" +
        "  { \"type\": \"Image\", \"url\": \"https://www.logolynx.com/images/logolynx/a4/a4a6d38594495045fe4a52f6ebb4551b.png\" },\n" +
        "\n" +
        "  { \"type\": \"TextField\", \"placeholder\": \"username\" },\n" +
        "\n" +
        "  { \"type\": \"TextField\", \"placeholder\": \"password\" }, { \"type\": \"Button\", \"label\": \"Submit\", \"background-color\": \"Red\" },{ \"type\": \"Button\", \"label\": \"ForgotPassword\", \"background-color\": \"Blue\" }\n" +
        "\n" +
        "]"
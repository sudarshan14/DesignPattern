package com.amlavati.tdd

import FavouriteList
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amlavati.tdd.ui.theme.DesignPatternsTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PlayListFeature {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun displayScreenTitle() {
        composeTestRule.setContent {
            DesignPatternsTheme {
                FavouriteList()
            }
        }
        composeTestRule.onNodeWithText("Hello Sudarshan").assertIsDisplayed()
    }


    @Test
    fun displayListOfPlayList(){
        composeTestRule.setContent {
            DesignPatternsTheme {
                FavouriteList()
            }
        }

//        composeTestRule.onAllNodesWithTag("favourite").assertCountEquals(10)
//        composeTestRule.onAllNodesWithTag("").get(0)

        composeTestRule.onNode(hasTestTag("favourite"))
            .onChildren()
            .assertCountEquals(10)[0].assert(hasText("0"))

    }
}
package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        composeTestRule.onNode(
            hasText(RallyScreen.Accounts.name.uppercase()) and
                    hasParent(hasContentDescription(RallyScreen.Accounts.name)),
            useUnmergedTree = true
        ).assertExists()
    }

    @Test
    fun rallyTopAppBarTest_switchLabelWhenSwitchingTab() {
        composeTestRule.setContent {
            RallyApp()
        }

        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Overview.name)
        ).performClick()

        composeTestRule.onNode(
            hasText(RallyScreen.Overview.name.uppercase()) and
                    hasParent(hasContentDescription(RallyScreen.Overview.name)),
            useUnmergedTree = true
        ).assertExists()

        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Bills.name)
        ).performClick()

        composeTestRule.onNode(
            hasText(RallyScreen.Bills.name.uppercase()) and
                    hasParent(hasContentDescription(RallyScreen.Bills.name)),
            useUnmergedTree = true
        ).assertExists()
    }
}
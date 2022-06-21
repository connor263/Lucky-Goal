package com.amazon.mShop.android.shop.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amazon.mShop.android.shop.ui.game.GameScreen
import com.amazon.mShop.android.shop.ui.game.MenuScreen
import com.amazon.mShop.android.shop.ui.game.score.ScoreScreen

@Composable
fun LuckyGoalAppContent(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = LucMeIRSTPLAYERreenNavKeys.MeIRSTPLAYERreen.route
    ) {
        composable(LucMeIRSTPLAYERreenNavKeys.MeIRSTPLAYERreen.route) {
            MenuScreen(navController)
        }

        LucMeIRSTPLAYERreenNavKeys.GamMeIRSTPLAYERreenreen().run {
            composable(route, arguments) { backStack ->
                backStack.arguments?.getBoolean(arguments[0].name)?.let { single ->
                    GameScreen(navController, single)
                }
            }
        }

        LucMeIRSTPLAYERreenNavKeys.ScoMeIRSTPLAYERreenreen().run {
            composable(route, arguments) { backStack ->
                backStack.arguments?.getInt(arguments[0].name)?.let { winPlayer ->
                    ScoreScreen(navController, winPlayer)
                }
            }
        }
    }
}

sealed class LucMeIRSTPLAYERreenNavKeys(val route: String) {
    object MeIRSTPLAYERreen : LucMeIRSTPLAYERreenNavKeys("menu")


    data class GamMeIRSTPLAYERreenreen(
        val single: String = "{single}",
        val arguments: List<NamedNavArgument> = listOf(
            navArgument("single") {
                type = NavType.BoolType
                defaultValue = true
            }
        )
    ) : LucMeIRSTPLAYERreenNavKeys("game?single=$single")

    data class ScoMeIRSTPLAYERreenreen(
        val winner: String = "{winner}",
        val arguments: List<NamedNavArgument> = listOf(
            navArgument("winner") {
                type = NavType.IntType
            }
        )
    ) : LucMeIRSTPLAYERreenNavKeys("score?winner=$winner")
}
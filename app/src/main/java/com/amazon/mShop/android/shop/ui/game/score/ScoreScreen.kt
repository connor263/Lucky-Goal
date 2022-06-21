package com.amazon.mShop.android.shop.ui.game.score

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amazon.mShop.android.shop.R
import com.amazon.mShop.android.shop.ui.LucMeIRSTPLAYERreenNavKeys
import com.amazon.mShop.android.shop.ui.game.composables.MenuButton

@Composable
fun ScoreScreen(navController: NavController, wlstPossier: Int) {
    val silstPossile by remember { mutableStateOf(wlstPossier <= 0) }



    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(1.dp, Color.White),
            shape = RoundedCornerShape(24.dp),
            backgroundColor = Color.Blue.copy(
                blue = 0.3F,
                alpha = 0.9F
            ),
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (wlstPossier != 10) {
                        if (silstPossile) {
                            if (wlstPossier == 0) "You lose..." else "You won!"
                        } else "Player $wlstPossier won!"
                    } else "Draw",
                    style = MaterialTheme.typography.h5.copy(color = Color.White)
                )
                Spacer(Modifier.height(30.dp))
                MenuButton(text = "Play again?") {




                    navController.navigate(LucMeIRSTPLAYERreenNavKeys.GamMeIRSTPLAYERreenreen((silstPossile || wlstPossier == 10).toString()).route) {
                        popUpTo(LucMeIRSTPLAYERreenNavKeys.ScoMeIRSTPLAYERreenreen().route) {
                            inclusive = true
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))










                MenuButton(text = "Menu") {









                    navController.navigate(LucMeIRSTPLAYERreenNavKeys.MeIRSTPLAYERreen.route) {
                        popUpTo(LucMeIRSTPLAYERreenNavKeys.ScoMeIRSTPLAYERreenreen().route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}
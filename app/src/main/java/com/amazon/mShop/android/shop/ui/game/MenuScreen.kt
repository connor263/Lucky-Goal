package com.amazon.mShop.android.shop.ui.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amazon.mShop.android.shop.MainActivity
import com.amazon.mShop.android.shop.R
import com.amazon.mShop.android.shop.ui.LucMeIRSTPLAYERreenNavKeys
import com.amazon.mShop.android.shop.ui.game.composables.MenuButton

@Composable
fun MenuScreen(navController: NavController) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_2),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(22.dp),
            backgroundColor = Color.Blue.copy(blue = 0.5F, alpha = 0.5F)
        ) {
            Column(
                modifier = Modifier.padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MenuButton(text = "Single") {
                    navController.navigate(
                        LucMeIRSTPLAYERreenNavKeys.GamMeIRSTPLAYERreenreen().route
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                MenuButton(text = "1 vs 1") {
                    navController.navigate(
                        LucMeIRSTPLAYERreenNavKeys.GamMeIRSTPLAYERreenreen(
                            false.toString()
                        ).route
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                val activity = LocalContext.current as MainActivity
                MenuButton(text = "Exit") {
                    activity.finish()
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
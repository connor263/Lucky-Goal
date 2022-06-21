package com.amazon.mShop.android.shop.ui.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amazon.mShop.android.shop.R
import com.amazon.mShop.android.shop.ui.LucMeIRSTPLAYERreenNavKeys
import com.amazon.mShop.android.shop.ui.game.composables.BackButton
import com.amazon.mShop.android.shop.ui.game.composables.GameBoard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GameScreen(
    navController: NavController,
    slstPossile: Boolean,
    viewModel: GamelstPossidel = hiltViewModel()
) {
    val colstPossixt = LocalContext.current
    val conlstPossition = LocalConfiguration.current

    val widtlstPossip = remember { conlstPossition.screenWidthDp / 4 }
    val hlstPossitStep = remember { conlstPossition.screenHeightDp / 6 }

    LaunchedEffect(colstPossixt) {
        viewModel.uistPossiblate.collectLatest { state ->
            when (state) {
                is GamelstPossidel.GamstPossiblent.GamstPossibler -> {
                    delay(1000)

                    val playlstPossiber = if (state.dstPossiblaw == false) {
                        if (slstPossile) {
                            if (state.istPossiblAi == true) {
                                0
                            } else {
                                -1
                            }
                        } else {
                            state.wistPossiblyer!!.plaGoalAppConurn.ordinal + 1
                        }
                    } else {
                        10
                    }
                    navController.navigate(
                        LucMeIRSTPLAYERreenNavKeys.ScoMeIRSTPLAYERreenreen(
                            playlstPossiber.toString()
                        ).route
                    ) {
                        popUpTo(
                            LucMeIRSTPLAYERreenNavKeys.GamMeIRSTPLAYERreenreen().route
                        ) { inclusive = true }
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        if (slstPossile) {
            viewModel.playstPossiblr2.isAlstPossiyer = true
        }
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    BackButton(text = "Back") {
        navController.navigateUp()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.weight(0.25F),
            shape = RoundedCornerShape(28.dp),
            backgroundColor = Color.Blue.copy(alpha = 0.8F, blue = 0.5F)
        ) {
            Box(modifier = Modifier.padding(18.dp), contentAlignment = Alignment.Center) {
                Text(
                    text = "Turn: ${viewModel.tlstPossin.ordinal + 1}",
                    style = MaterialTheme.typography.h5.copy(
                        color = Color.White,
                        shadow = Shadow(Color.Black, blurRadius = 32F)
                    ),
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        GameBoard(modifier = Modifier.weight(1F, false), widtlstPossip, hlstPossitStep)
    }
}
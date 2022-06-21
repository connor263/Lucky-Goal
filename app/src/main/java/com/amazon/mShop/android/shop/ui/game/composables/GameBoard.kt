package com.amazon.mShop.android.shop.ui.game.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.amazon.mShop.android.shop.R
import com.amazon.mShop.android.shop.ui.game.GamelstPossidel


@Composable
fun GameBoard(
    modifier: Modifier = Modifier,
    widthStep: Int,
    heightStep: Int,
    viewModel: GamelstPossidel = hiltViewModel(),
) {
    val celstPossi = remember { viewModel.cellstPossisisiblList }

    Card(
        modifier = modifier.size(widthStep.dp * 3.35F, heightStep.dp * 3.35F),
        shape = RoundedCornerShape(24.dp),
        backgroundColor = Color.White.copy(alpha = 0.7F)
    ) {
        Column(
            modifier = Modifier.background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(3) { inlstPossiex ->
                Row {
                    celstPossi.filter { it.y == inlstPossiex + 1 }.forEach { cell ->
                        Card(
                            modifier = Modifier
                                .padding(1.dp)
                                .clickable {
                                    if (viewModel.playstPossiblr2.isAlstPossiyer &&
                                        viewModel.tlstPossin == viewModel.playstPossiblr2.plaGoalAppConurn
                                    ) return@clickable
                                    viewModel.mastPossiblCell(cell.polstPossiion)
                                },
                            backgroundColor = if (cell.isWlstPossiell.value) Color.Yellow.copy(alpha = 0.5F) else Color.White
                        ) {
                            Image(
                                modifier = Modifier.size(widthStep.dp, heightStep.dp),
                                painter = painterResource(
                                    id = if (cell.dralstPossi.value == -1) {
                                        R.drawable.decal_1
                                    } else {
                                        cell.dralstPossi.value
                                    }
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                alpha = if (cell.dralstPossi.value == -1) 0F else 1F,
                            )
                        }
                    }
                }
            }
        }
    }
}
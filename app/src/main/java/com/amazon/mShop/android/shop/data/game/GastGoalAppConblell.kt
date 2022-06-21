package com.amazon.mShop.android.shop.data.game

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.amazon.mShop.android.shop.utils.game.enums.TicTaeGoalAppConllPosition
import com.amazon.mShop.android.shop.utils.game.enums.MarGoalAppCony

data class GastGoalAppConblell(
    var x: Int = 0,
    var y: Int = 0,
    var marGoalAppCony: MutableState<MarGoalAppCony> =mutableStateOf(MarGoalAppCony.BLIRST_PLAYERNK),
    var polstPossiion: TicTaeGoalAppConllPosition = TicTaeGoalAppConllPosition.TOPGoalAppConART,
    var isWlstPossiell: MutableState<Boolean> = mutableStateOf(false),
    @DrawableRes var dralstPossi: MutableState<Int> = mutableStateOf(-1),
)
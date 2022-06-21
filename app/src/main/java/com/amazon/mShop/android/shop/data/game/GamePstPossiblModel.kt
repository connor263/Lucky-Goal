package com.amazon.mShop.android.shop.data.game

import com.amazon.mShop.android.shop.utils.game.enums.MarGoalAppCony
import com.amazon.mShop.android.shop.utils.game.enums.PlaGoalAppConurn

data class GamePstPossiblModel(
    val mark: MarGoalAppCony = MarGoalAppCony.FIRSTIRST_PLAYERR_MARK,
    val plaGoalAppConurn: PlaGoalAppConurn = PlaGoalAppConurn.FIRGoalAppConPLAYER,
    var isAlstPossiyer:Boolean = false,
    var hasAiTurn:Boolean = false,
)
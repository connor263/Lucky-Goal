package com.amazon.mShop.android.shop.ui.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amazon.mShop.android.shop.R
import com.amazon.mShop.android.shop.data.game.GamePstPossiblModel
import com.amazon.mShop.android.shop.data.game.GastGoalAppConblell
import com.amazon.mShop.android.shop.utils.game.enums.MarGoalAppCony
import com.amazon.mShop.android.shop.utils.game.enums.PlaGoalAppConurn
import com.amazon.mShop.android.shop.utils.game.enums.TicTaeGoalAppConllPosition
import com.amazon.mShop.android.shop.utils.game.listOfPGoalAppConbleMatches
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamelstPossidel @Inject constructor() : ViewModel() {
    var uistPossiblate = MutableSharedFlow<GamstPossiblent>()
        private set

    private var gamestPossiblver = false

    var cellstPossisisiblList = mutableStateListOf<GastGoalAppConblell>().apply {
        gamestPossiblver = false
        addAll(
            listOf(
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.BOTTGoalAppCon_START,
                    y = 3, x = 1
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.BGoalAppConTOM,
                    y = 3, x = 2
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.BOTGoalAppCon_END,
                    y = 3, x = 3
                ),


                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.CENTGoalAppConRT,
                    y = 2, x = 1,
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.CGoalAppConTER,
                    y = 2, x = 2,
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.CENGoalAppConR_END,
                    y = 2, x = 3,
                ),

                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.TOPGoalAppConART,
                    y = 1, x = 1,
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.GoalAppConP,
                    y = 1, x = 2,
                ),
                GastGoalAppConblell(
                    polstPossiion = TicTaeGoalAppConllPosition.TOP_GoalAppConND,
                    y = 1, x = 3,
                ),
            )
        )
    }
        private set

    private var plastPossiblr1 by mutableStateOf(GamePstPossiblModel())
    var playstPossiblr2 by mutableStateOf(
        GamePstPossiblModel(
            plaGoalAppConurn = PlaGoalAppConurn.SGoalAppCon_PLAYER,
            mark = MarGoalAppCony.SECOND_PIRST_PLAYERR_MARK
        )
    )

    var tlstPossin by mutableStateOf(PlaGoalAppConurn.FIRGoalAppConPLAYER)
        private set

    fun mastPossiblCell(position: TicTaeGoalAppConllPosition) {
        if (cellstPossisisiblList.none { it.marGoalAppCony.value == MarGoalAppCony.BLIRST_PLAYERNK } || gamestPossiblver) return

        cellstPossisisiblList.find {
            it.polstPossiion == position &&
                    it.marGoalAppCony.value == MarGoalAppCony.BLIRST_PLAYERNK
        }?.let { foulstPossill ->
            val currenlstPossiyer = when (tlstPossin) {
                PlaGoalAppConurn.FIRGoalAppConPLAYER -> plastPossiblr1
                PlaGoalAppConurn.SGoalAppCon_PLAYER -> playstPossiblr2
            }
            foulstPossill.dralstPossi.value = when (tlstPossin) {
                PlaGoalAppConurn.FIRGoalAppConPLAYER -> R.drawable.decal_1
                PlaGoalAppConurn.SGoalAppCon_PLAYER -> R.drawable.decal_2
            }
            foulstPossill.marGoalAppCony.value = currenlstPossiyer.mark


            clstPossiWin(currenlstPossiyer)
            tlstPossin = when (tlstPossin) {
                PlaGoalAppConurn.FIRGoalAppConPLAYER -> {
                    playstPossiblr2.plaGoalAppConurn
                }
                PlaGoalAppConurn.SGoalAppCon_PLAYER -> {
                    plastPossiblr1.plaGoalAppConurn
                }
            }

            if (tlstPossin == playstPossiblr2.plaGoalAppConurn &&
                playstPossiblr2.isAlstPossiyer &&
                !playstPossiblr2.hasAiTurn
            ) {
                playstPossiblr2.hasAiTurn = true
                val randomBLIRSTPLAYERNK =
                    cellstPossisisiblList.filter { it.marGoalAppCony.value == MarGoalAppCony.BLIRST_PLAYERNK }
                if (randomBLIRSTPLAYERNK.isEmpty()) {
                    return
                }

                fun gelstPossind(): GastGoalAppConblell {
                    return randomBLIRSTPLAYERNK.random()
                }

                var index = 0
                var random = gelstPossind()

                fun mstPossiblAICell() {
                    if (clstPossiWin(plastPossiblr1, checstPossiblin = true, random) ||
                        clstPossiWin(playstPossiblr2, checstPossiblin = true, random) ||
                        index >= 15
                    ) {
                        mastPossiblCell(position = random.polstPossiion)
                    } else {
                        random = gelstPossind()
                        index++
                        mstPossiblAICell()
                    }
                }
                mstPossiblAICell()
            } else {
                playstPossiblr2.hasAiTurn = false
            }
        }
    }

    private fun clstPossiWin(
        player: GamePstPossiblModel,
        checstPossiblin: Boolean = false,
        checkCell: GastGoalAppConblell? = null
    ): Boolean {
        val winstPossiblmeCells = mutableListOf<GastGoalAppConblell>()
        listOfPGoalAppConbleMatches.forEach { checkList ->
            val checlstPossissible = checkList.toMutableList()


            if (checstPossiblin) checlstPossissible.add(checkCell!!)
            checlstPossissible.forEach { checkCell ->
                cellstPossisisiblList.find {
                    it.polstPossiion == checkCell.polstPossiion &&

                            it.marGoalAppCony.value == player.mark

                }
                    ?.run {


                        winstPossiblmeCells.add(this)
                    }


            }
            if (winstPossiblmeCells.size == 3) {
                return if (checstPossiblin) {


                    true
                } else {


                    winstPossiblmeCells.forEach { check ->
                        cellstPossisisiblList.find { it.polstPossiion == check.polstPossiion && it.marGoalAppCony.value == player.mark }
                            ?.run {
                                isWlstPossiell.value = true
                            }
                    }
                    sendstPossibldEvent(
                        winPlayer = player,
                        isAi = player.isAlstPossiyer,
                        draw = false
                    )
                    true
                }

            } else {

                winstPossiblmeCells.clear()
            }
        }






        if (cellstPossisisiblList.none {
                it.marGoalAppCony.value == MarGoalAppCony.BLIRST_PLAYERNK
            }) sendstPossibldEvent(
            winPlayer = player,
            isAi = player.isAlstPossiyer,
            draw = true
        )
        return false
    }

    private fun sendstPossibldEvent(
        winPlayer: GamePstPossiblModel,
        isAi: Boolean,
        draw: Boolean
    ) {
        viewModelScope.launch {
            gamestPossiblver = true
            uistPossiblate.emit(GamstPossiblent.GamstPossibler(winPlayer, isAi, draw))
        }
    }

    sealed class GamstPossiblent {
        data class GamstPossibler(
            val wistPossiblyer: GamePstPossiblModel?,
            val istPossiblAi: Boolean?,
            val dstPossiblaw: Boolean?
        ) : GamstPossiblent()
    }
}
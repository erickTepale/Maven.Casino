package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Bin;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;

public class GoFish extends CardGame implements Bin {
    private GoFishPlayer player;
    private GoFishPlayer dealer;

    public GoFish(BasePlayer player, BasePlayer dealer) {
        this.player = (GoFishPlayer) player;
        this.dealer = (GoFishPlayer) dealer;
    }


    public void add(Integer valueOfDice) {

    }

    @Override
    public void remove(Integer index) {

    }
//
//    public void remove(Integer index) {
//
//    }
//
//    public Boolean isWin() {
//        return null;
//    }

    public void switchTurns() {

    }
}
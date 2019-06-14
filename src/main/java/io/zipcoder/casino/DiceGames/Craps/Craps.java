package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.UtilitiesDice.DiceGame;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.GamblingGame;

public class Craps extends DiceGame implements GamblingGame {
    private Integer minBet;
    CrapsPlayer player;
    CrapsPlayer dealer;

    public Craps(BasePlayer base, BasePlayer dealer){
        this.player = (CrapsPlayer) base;
        this.dealer = (CrapsPlayer) dealer;
    }


    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    @Override
    public void welcomeMessage() {

    }

    public String placeWager() {
        return null;
    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }
}
package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.GamblingGame;

public class Blackjack extends CardGame implements GamblingGame {
    private Integer minBet;
    private BasePlayer player;
    private BasePlayer dealer;

    public Blackjack(BasePlayer base, BasePlayer dealer) {
        this.player = base;
        this.dealer = dealer;
    }



    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {
        BasePlayer temp = new BasePlayer("test");


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
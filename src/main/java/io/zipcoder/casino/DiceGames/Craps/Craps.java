package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.UtilitiesDice.DiceGame;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

public class Craps extends DiceGame implements GamblingGame {
    private Integer minBet;
    CrapsPlayer player;
    CrapsPlayer dealer;
    private Console console;


    public Craps(BasePlayer base, BasePlayer dealer){
        super();
        this.player = (CrapsPlayer) base;
        this.dealer = (CrapsPlayer) dealer;
        this.minBet = 20;
        player.roll(2);
    }



    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    @Override
    public void welcomeMessage() {

           console.println("WELCOME TO THE CRAPS TABLE");


    }

    public Integer placeWager() {

        int bet = 0;
        console.getIntegerInput("Please input a wager(Min bet: $" + minBet + ")", bet);
        return bet;

    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }
}
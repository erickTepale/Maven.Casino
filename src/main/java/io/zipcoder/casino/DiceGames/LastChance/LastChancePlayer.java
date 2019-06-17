package io.zipcoder.casino.DiceGames.LastChance;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;

import java.util.List;

public class LastChancePlayer extends BasePlayer {
    private BasePlayer player;
    private Integer betAmpout;
    private Integer pot;



    private List<Dice> bin;

    public LastChancePlayer(String name, List<Dice> bin) {
        super(name);
        this.bin = bin;
    }

    public void dealerRoll(){
    }
    public void rollDice(){

    }
    public void checkWinLC(){
    }
    public void playAgain(){

    }
}
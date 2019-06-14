package io.zipcoder.casino.DiceGames.UtilitiesDice;

import io.zipcoder.casino.utilities.Game;

import java.util.ArrayList;

public abstract class DiceGame extends Game {
    private Dice dice;

    public int rollDice(){
        return Dice.roll();
    }


}

package io.zipcoder.casino.DiceGames.UtilitiesDice;

import io.zipcoder.casino.utilities.Game;

import java.util.ArrayList;

public abstract class DiceGame extends Game {
    private Dice dice;

    public int rollDice(){
        int dieSum = 0 ;
        ArrayList<Integer> diceList = new ArrayList<Integer>();
         diceList = Dice.roll(2);
         for(int i = 0 ; i<diceList.size(); i++){
             dieSum = dieSum + diceList.get(i);
         }
        return dieSum;
    }


}

package io.zipcoder.casino.DiceGames.UtilitiesDice;

import io.zipcoder.casino.utilities.Bin;

import java.util.ArrayList;

public class Dice implements Bin {
    static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);



    public static ArrayList roll(int numOfDice){
        for (int i = 0; i < numOfDice; i++) {
            int die = (int) (Math.random() * 6 + 1);
            playerDice.add(i, die);
        }
        return playerDice;
    }


    public ArrayList compare(Dice dice){

        return null;
    }

    public void add(Integer valueOfDice) {

    }

    public void remove(Integer index) {

    }
}



package io.zipcoder.casino.DiceGames.UtilitiesDice;

import io.zipcoder.casino.utilities.Bin;

import java.util.ArrayList;

public class Dice implements Bin {
    static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);


    public Dice() {

    }


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


    public Integer rollDice(){

        return null;
    }

   public Integer rollOneDIe() {
        return null;
    }

    public Integer rollTwoDice() {
        return null;
    }

    public Integer rollThreeDie() {
        return null;
    }

    public Integer rollFourDie() {
        return null;
    }

    public Integer rollFiveDie() {
        return null;
    }
}



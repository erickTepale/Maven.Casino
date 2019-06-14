package io.zipcoder.casino.DiceGames.UtilitiesDice;

import io.zipcoder.casino.utilities.Bin;

import java.util.ArrayList;

public class Dice implements Bin {

    public static ArrayList<Integer> dealerDice = new ArrayList<Integer>(5);
    public static ArrayList<Integer> playerDice = new ArrayList<Integer>(5);
    public static ArrayList<Integer> heldDice = new ArrayList<Integer>(5);
    public static Integer numOfDice = 0;



    public Dice() {

    }


    public static ArrayList roll(int numOfDice){
        for (int i = 0; i < numOfDice; i++) {
            int die = (int) (Math.random() * 6 + 1);
            playerDice.add(i, die);
        }
        return playerDice;
    }

    public static Integer roll (){
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += (int) (Math.random() * 6 + 1);
        }
        return sum;
    }


    public static ArrayList compare(Dice dice){

        return null;
    }

    // Called by LastChance.playGame() to compare dealerDice and playerDice, returns heldDice
    // Called by LastChance.checkWin() to compare dealerDice and heldDice, return ArrayList of 5 Integers sets win
    public static ArrayList compare(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList sameDice = new ArrayList(5);

        return sameDice;
    }

    public void add(Integer valueOfDice) {

    }

    public void remove(Integer index) {

    }


    public Integer rollDice(){

        return null;
    }


}



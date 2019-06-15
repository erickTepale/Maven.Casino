package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;
import io.zipcoder.casino.DiceGames.UtilitiesDice.DiceGame;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

public class Craps extends DiceGame implements GamblingGame {
    private Integer minBet;
    CrapsPlayer player;
    CrapsPlayer dealer;
    private Console console;
    private int startBet;


    public Craps(BasePlayer base, BasePlayer dealer){
        super();
        this.player = (CrapsPlayer) base;
        this.dealer = (CrapsPlayer) dealer;
        this.startBet = 0;
        this.minBet = 20;
    }

    private void initGame () {
        String Menu = "";
        do {
            Menu = console.getStringInput(printMenu());
            switch (Menu.toUpperCase()){
                case "RULES": printRules();
                break;
                case "Play": console.println(placeWager());
                if (startBet >0 ){
                    roll();
                }
                break;
            }
        } while (!Menu.equals("quit"));

    }

    public Integer roll() {
        return super.rollDice();
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


    public String placeWager() {
        int bet = 0;
        if (bet < minBet) {
        bet = console.getIntegerInput("Please input a wager(Min bet: $" + minBet + ")", bet);
            return null;
        }
        return null;
    }



    public void printRules() {
        console.println("\nRULES" +
                "\n If you get 7 or 11 on your first roll, You Win\n" +
                "If you get 2 or 3 or 12 on your first roll, You Lose\n " +
                "If you get 4 or 5 or 6 or 8 or 9 or 10 on your first roll, You need to match that number to win but if you roll 7 or 11 before then, you Lose. \n" +
                "You place your initial wager to play the game and double the money");
    }

    public String printMenu(){

        return "\nPlease Type In An Option: " +
                "\nPlay:              [Play]" +
                "\nSee Rules:         [Rules]";
    }
    @Override
    public void increaseMinBet() {

    }

    @Override
    public void decreaseMinBet() {

    }

}
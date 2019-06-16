package io.zipcoder.casino.DiceGames.LastChance;

import io.zipcoder.casino.DiceGames.UtilitiesDice.DiceGame;
import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.GamblingGame;
import io.zipcoder.casino.utilities.Lobby;

import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Formatter;

import static io.zipcoder.casino.DiceGames.UtilitiesDice.Dice.*;
import static io.zipcoder.casino.utilities.Lobby.*;

public abstract class LastChance extends DiceGame implements GamblingGame{
    /**
     *   public void initGame(){
     *      String input = "";
     *      while(input.equals("quit"){
     *          switch (input)
     *              -> quit
     *                      break;
     *              -> "play"
     *                      welcomeMessage(); //this
     *                      setupGame(); //this
     *                      placeWager(); //LastChancePlayer
     *                      dealerRoll(); //LastChancePlayer
     *                      playerPlayGame(); //this -> 5times
     *                      printResult(); //this
     */

    Integer bet = 0;
    Integer rolls = 0;
    Integer diceRemaining = 5;
    Integer pot = 0;
    Integer multiplier = 1;
    String gameScreen =
            "LastChance..."; //Continue with stringbuilder


    public void welcomeScreen(String arg[]){
        String welcomeScreen = String.format
                ("\tTo win this game, you must match the dealers 5 dice \n" +
                "\tin a limited amount of rolls. The dealer will hold \n" +
                "matching dice between rolls to maximize your chances.\n\tExample 1:\n" +
                        "\tDealer Dice: 1,1,3,5,5\n" +
                        "\tPlayer Dice: 2,3,5,6,6\n" +
                        "\n" +
                        "\tIn this example, the dealer will hold your 3 and 5.\n" +
                        "\t\n" +
                        "\tDealer Dice: 1,1,3,5,5\n" +
                        "\tPlayer Dice: 2,3,5,6,6\n" +
                        "\tMatching Dice: 3,5\n" +
                        "\tDice Remaining: 3\n" +
                        "\tRolls Remaining: 4\n" +
                        "\t\n" +
                        "\t\n" +
                        "\tIf you have rolls remaining, you may roll the remaining \n" +
                        "\t3 dice and try to match the rest of the needed dice to win.\n" +
                        "\tThe amount of rolls you select at the begining of the game \n" +
                        "\twill change both the difficulty and reward! The reward is \n" +
                        "\tset as a multiplier of your chosen bet. Below is a table\n" +
                        "\tof the total rolls per game and associated reward!\n" +
                        "\t\n" +
                        "\t5 rolls = 2 x bet\n" +
                        "\t4 rolls = 3 x bet\n" +
                        "\t3 rolls = 4 x bet\n" +
                        "\t2 rolls = 5 x bet\n" +
                        "\t\n" +
                        "\tNow that you know how to play, enter your bet as a positive \n" +
                        "\tinteger, followed by a comma, and your chosen multiplier as \n" +
                        "\tan integer between 2 and 5.\n");
    }



    public void initGame(){
        // Resets bet, rolls, diceRemaining, pot, and multiplier each game
        bet = 0;
        rolls = 0;
        diceRemaining = 5;
        pot = 0;
        multiplier = 1;

        String input = "";
        while (input.equals("quit")) {
            switch (input) {
                case "quit":
                    break;
                case "play":
                    welcomeMessage(); //Print welcome, prompt input, call setupGame()
                    setupGame(bet, multiplier); //use input to set bet, multiplier, pot, rolls, and calls playGame()
                    playGame();
   //                 printResult();
            }
        }
    }
    public void setupGame(Integer ibet,Integer iMultiplier){
        bet = ibet;
        multiplier = iMultiplier;
        pot = bet * multiplier;
        rolls = 7 - multiplier;
    }

    public void playGame(){
        String gameScreen = String.format("\n" +
                "\t\t\t\tLast Chance\n" +
                "\t%1$s's Wallet: %2$s           Possible Winnings: %3$s\n" +
                "\t\n" +
                "\tDealer Dice: %4$d\n" +
                "\tPlayer Dice: %5$d\n" +
                "\tMatching Dice: %6$d\n" +
                "\tRolls remaining: %7$d\n" +
                "\t\n" +
                "\tEnter 'roll' to roll the dice or 'lobby' to forfiet your bet.\n");
        // why can't I use name, and wallet from BasePlayer.basePlayer?
//                , name, wallet, pot, dealerDice, playerDice, heldDice, rolls);
        // Call setNumOfDice
        Dice.roll(numOfDice); //sets return Integer[] playerDice
        rolls--;
        Dice.compare(dealerDice,playerDice); //sets return Integer[] heldDice
        while(rolls > 0){
            this.printGame(); //While rolls are remaining, returns player to printGame()
        }
        this.checkWin(dealerDice, heldDice); //sets return Boolean winLC

    }

    public void printGame(){
        System.out.print(gameScreen);
        boolean b = false;
        do{
            try{
                Scanner n = new Scanner(System.in);
                boolean bn = n.nextBoolean();
                if (bn == true){
                    this.playGame();
                } else if(bn == false){ //Change this to "roll", "lobby", or exception
     //               Lobby.lobby();
                }
            } catch(InputMismatchException e){
                System.out.println("Sorry, I didn't quite catch that. Type either 'roll' or lobby'");
            }
        } while(!b);
    }

    public Boolean checkWin(ArrayList<Integer> dealerDice, ArrayList<Integer> heldDice) {
        Boolean win = false;
        Dice.compare(Dice.dealerDice, Dice.heldDice);
        return win;
    }
}


























    /*
    //instance vars
    private LastChancePlayer player;
    private LastChancePlayer dealer;

    //Variablesfromotherclasses
    Integer bet=0;
    Integer playerWallet=3000;

    //Variables
    Integer[]neededDice = new Integer[5]; //Dice to match
    Integer[]playerDice = new Integer[5]; //Dice the player rolls each turn
    Integer[]heldDice = new Integer[5]; //Dice that matches neededDice
    String welcomeMessage = "Welcome..."; //Continue with stringbuilder
    String gameScreen = "LastChance..."; //Continue with stringbuilder
    String playAgainMessage = "Would you like to play again? Type 'y' to play again or 'n' to return to the lobby.";
    Boolean playAgain = true;
    Boolean winLC = false;
    Boolean roll = true; //Set in printGameLC and sent to playGame
    Integer rolls = 0;
    Integer pot = 0;
    Integer multiplier = 1;
    Integer numberOfDice = 5; //Will change as the game continues

    /* README
    Lobby class directs to welcomeLC()
    welcomeLC() prompts input and calls setupLC()
    setupLC() sets bet, multiplier, possibleWinning, and rolls. And calls printGameLC()
    printGameLC() prompts input and calls either playGame() or Lobby
    playGame() calls Dice.roll()






    public static void welcomeLC(){
        //String.format welcomeMessage here
            }

    public void setupLC(Integer ibet,Integer iMultiplier){
            bet = ibet;
            multiplier = iMultiplier;
            possibleWinning = bet * multiplier;
            rolls = 7 - multiplier;
            }
    public void printGameLC(){
            System.out.print(gameScreen);
            boolean b = false;
            do{
                try{
                Scanner n = new Scanner(System.in);
                boolean bn = n.nextBoolean();
                if (bn == true){
                    this.playGameLC();
                } else if(bn == false){ //Change this to "roll", "lobby", or exception
                    this.returnToLobby();
                }
                } catch(InputMismatchException e){
                    System.out.println("Sorry, I didn't quite catch that. Type either 'roll' or lobby'");
                }
            } while(!b);
            }
    private InputStream Scanner(InputStream in){ //Needed to get user input maybe
        return in;
    }

    public void playGameLC(){
        Dice.roll(numberOfDice); //sets return Integer[] playerDice
        this.checkDice(neededDice,playerDice); //sets return Integer[] heldDice
        while(rolls > 0){
            this.printGameLC(); //While rolls are remaining, returns player to printGame()
        }
        this.checkWin(neededDice,heldDice); //sets return Boolean winLC

    }
    public void payBet(Integer bet){ //Will be moved to another class
        playerWallet -= bet;
    }
   /* public Integer[]roll(Integer numberOfDice){ //Will be moved to Diceclass
        for(int i = 0; i < numberOfDice; i++){
            int die = (int)(Math.random() * 6 + 1);
            playerDice[i]= die;
        }
        return playerDice;
    }



    public Integer[]checkDice(Integer[]neededDice,Integer[]playerDice){ //Compares neededDice, playerDice
        Arrays.sort(neededDice);
        Arrays.sort(playerDice);//********* Where I'm working atm ********



        return heldDice;
    }
    public Boolean checkWin(Integer[]neededDice,Integer[]heldDice){ //Compares neededDice, heldDice
        Arrays.sort(neededDice);
        Arrays.sort(heldDice);
        if(Arrays.equals(neededDice,heldDice)){
            winLC=true;
        } else{
            winLC=false;
        }
        return winLC;
        }
    public Boolean getPlayAgain(Character iPlayAgain){

        return playAgain;
        }
    public void returnToLobby(){

    }

    @Override
    public void welcomeMessage() {

    }

    @Override
    public String placeWager() {
        return null;
    }

    @Override
    public void increaseMinBet() {

    }

    @Override
    public void decreaseMinBet() {

    }


     */




































/*
public class LastChance extends DiceGame implements GamblingGame {
    private LastChancePlayer player;
    private LastChancePlayer dealer;

    public void lastChanceSetup(){
    }
    public void printGame(){
    }
    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    public void placeWager() {

    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }
}

 */
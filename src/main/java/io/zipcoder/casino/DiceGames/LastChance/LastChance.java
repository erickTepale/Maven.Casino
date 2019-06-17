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
    public static Object set;
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
    String gameScreen = "";
    BasePlayer player;


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
                    welcomeMessage(); //Print welcome, prompt input
                    setupGame(bet, multiplier); //use input to set bet, multiplier, pot, rolls, and calls playGame()
                    playGame();
                    //                 printResult();
            }
        }
    }


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
        System.out.println(welcomeScreen);
    }
    public LastChancePlayer getPlayer() { return (LastChancePlayer) player; }

    public void setPlayer(LastChancePlayer player) { this.player = player; }



    public void setupGame(Integer iBet,Integer iMultiplier){
        //Run check that iBet <= wallet && 2 < iMultiplier <7
        while(player.removeFromWallet(iBet) == false) { //Call the players wallet, not the class's wallet
            //error message
        }
        bet = iBet;
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
        Dice.setNumOfDice(5 - heldDice.size()); //sets Integer numOfDice to what hasn't been held yet
        Dice.roll(numOfDice); //sets Integer[] playerDice
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

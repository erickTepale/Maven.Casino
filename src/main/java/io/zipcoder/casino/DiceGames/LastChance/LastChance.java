package io.zipcoder.casino.DiceGames.LastChance;

import io.zipcoder.casino.DiceGames.UtilitiesDice.DiceGame;
import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;
import io.zipcoder.casino.utilities.GamblingGame;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class LastChance{


    //Variablesfromotherclasses
    Integer bet=0;
    Integer playerWallet=3000;

    //Variables
    Integer[]neededDice = new Integer[5]; //Dice to match
    Integer[]playerDice = new Integer[5]; //Dice the player rolls each turn
    Integer[]heldDice = new Integer[5]; //Dice that matches neededDice
    String welcomeMessage = "Welcome..."; //Continue with stringbuilder
    String gameScreen = "LastChance..."; //Continue with stringbuilder
    String playAgainMessage = "Wouldyouliketoplayagain?Type'y'toplayagainor'n'toreturntothelobby.";
    Boolean playAgain = true;
    Boolean winLC = false;
    Boolean roll = true; //Set in printGameLC and sent to playGame
    Integer rolls = 0;
    Integer possibleWinning = 0;
    Integer multiplier = 1;
    Integer numberOfDice = 5; //Will change as the game continues

    public static void welcomeLC(){
        //String.format welcomeMessage here
            }

    public void setupLC(Integer iBet,Integer iMultiplier){
            bet = iBet;
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
        while(rolls < 0){
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
    */
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

}


































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
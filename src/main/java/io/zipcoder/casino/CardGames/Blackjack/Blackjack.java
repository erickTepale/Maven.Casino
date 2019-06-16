package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.ConsoleIO;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;
import java.util.List;

public class Blackjack extends CardGame implements GamblingGame {
    private Integer minBet;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private Integer betAmount;
    private Boolean currentGame = true;
    private Integer dealerHandValue;
    boolean isRunning = true;
    boolean playerTurn = true;
    boolean playerBusted = false;

    public Blackjack() {
    }

    public Blackjack(BasePlayer base, BasePlayer dealer) {
        this.player = new BlackjackPlayer(base);
        this.dealer = new BlackjackPlayer(dealer);
    }

    public Blackjack(BasePlayer base, BasePlayer BJdealer, Console console) {


            this.player = new BlackjackPlayer(base);
            this.dealer = new BlackjackPlayer(BJdealer);
        while (isRunning) {
            gameReset();
            betAmount = console.getIntegerInput("Please enter your wager");
            while (currentGame) {
                console.println(placeWager(betAmount));
                setupBoard(console);
                while (checkPlayerAnswer(console)) {
                    //checkPlayerAnswer(console);
                    if(playerBustCheck()){ break;}

                    console.print(player.getHandValue().toString());
                }
                    if(playerBustCheck()){ break;}

                    dealerTurn(console);
                    if(dealerBustCheck()){break;}
                    //console.println(whoWins());
                    //console.print(Hand.showHand((ArrayList<Card>) dealer.hand));
                    //console.println(test.toString());

            }
            if(dealerBustCheck()){
                console.println("You won " + betAmount*2);
                player.addToWallet(betAmount*2);
            }else if(playerBustCheck()){
                console.println("You lost " + betAmount);

            }else if(player.getHandValue() > dealer.getHandValue()){
                console.println("You won " + betAmount*2);
                player.addToWallet(betAmount*2);

            }else if(player.getHandValue() < dealer.getHandValue()){
                console.println("You lost " + betAmount);

            }else if(player.getHandValue().equals(dealer.getHandValue())){
                player.addToWallet(betAmount);
                console.println("It was a push");
            }
        }
        }
        public void gameReset(){
        currentGame = true;
        playerTurn = true;
        }
        public Boolean playerBustCheck() {
            Integer num = 0;
            if(isAPresent(player.hand) > 0){
               num = 10 * isAPresent(player.hand);
            }
        if (player.getHandValue() - num > 21) {

                return true;
            } else {

                return false;
            }
        }


        public Boolean dealerBustCheck(){
            Integer num = 0;
            if(isAPresent(dealer.hand) > 0){
                num = 10 * isAPresent(dealer.hand);
            }
        if (dealer.getHandValue()-num > 21) {
                return true;
            } else {

                return false;
            }
        }
        public Integer isAPresent(List<Card> hand){
                Integer numofA = 0;
            for (int i = 0; i <hand.size(); i++) {

                if(hand.get(i).getFaceValue().getRankValue()== 1){

                numofA++;}

            }
            return numofA;
        }



        public void  dealerTurn(Console console){


        while(dealer.getHandValue() < 17){
            dealer.hand.add(super.draw());
            dealer.setHandValue(dealerHandValue());
            if(dealerBustCheck()){
                break;


            }

        }
            currentGame= false;
            console.print("Dealer hand: " + Hand.showHand((ArrayList<Card>) dealer.hand));
        }
        public boolean checkPlayerAnswer(Console console){
        String playerAnswer = console.getStringInput("\nWould you like to hit or stay?");
        if(playerAnswer.toUpperCase().equals("HIT")){

            player.hand.add(super.draw());
            player.setHandValue(playerHandValue());
            console.print(Hand.showHand((ArrayList<Card>) player.hand));
            if(playerBustCheck()){
                console.println(player.getName()+" busted "+ betAmount + " has been lost");
                playerBusted= true;
                 return false;

            }
            return true;

        }else if(playerAnswer.toUpperCase().equals("STAY")){
            return false;

        }
        return true;
        }
        public void setupBoard(Console console){
            playerBusted = false;
            player.setHand(super.deal(2));
            dealer.setHand(super.deal(1));
            console.println("Dealer is dealt");
            console.print(Hand.showHand((ArrayList<Card>) dealer.hand));
            console.println("\nPlayer is dealt");
            console.print(Hand.showHand((ArrayList<Card>) player.hand));
            player.setHandValue(playerHandValue());
            dealer.setHandValue(playerHandValue());

        }
        public Boolean playerWon(){

        player.addToWallet(betAmount*2);

            currentGame = false;
            return true;
        }
        public Boolean dealerWon(){
        currentGame=false;
        return true;
        }
        public Boolean push(){
            player.addToWallet(betAmount);
            currentGame = false;
        return true;
        }
        public void announceWinner(Console console){
        if(playerWon()){
            console.println("You won " + betAmount*2);

        }else if(dealerWon()){

        }
        }
        public void  whoWins(){


        if(player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22){



        }else if(player.getHandValue() == dealer.getHandValue()){

        }else{
            //answer = "Dealer Won";
            currentGame = false;
        }
        //return answer;
        }
        public Integer playerHandValue(){
            Integer playerHandValue= 0;
        for (int i = 0; i <player.hand.size(); i++) {

                playerHandValue += player.hand.get(i).getFaceValue().getBlackJackValue();

            }
        return playerHandValue;
        }
    public Integer dealerHandValue() {
        dealerHandValue = 0;
        for (int i = 0; i < dealer.hand.size(); i++) {

            dealerHandValue += dealer.hand.get(i).getFaceValue().getBlackJackValue();

        }
            return dealerHandValue;

    }
        public Boolean isWin(){
            return null;
        }

        public void switchTurns(){
            BasePlayer temp = new BasePlayer("test");
        }


        public void welcomeMessage(){

        }
        public String placeWager(){
        return null;
        }

    @Override
    public void increaseMinBet() {

    }

    @Override
    public void decreaseMinBet() {

    }

    public String placeWager(Integer betAmount){
            String answer;
            this.betAmount = betAmount;
            if (player.getPlayer().removeFromWallet(betAmount)) {
                answer = "Bet Amount of " + betAmount + " Confirmed";

            } else {
                answer = "You currently do not have enough money to make that wager";
            }
            return answer;

        }


    }



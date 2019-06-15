package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.ConsoleIO;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;

public class Blackjack extends CardGame implements GamblingGame {
    private Integer minBet;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private Integer betAmount;
    private Integer playerHandValue;
    private Integer dealerHandValue;
    boolean isRunning = true;
    boolean playerTurn = true;

    public Blackjack() {
    }

    public Blackjack(BasePlayer base, BasePlayer dealer) {
        this.player = new BlackjackPlayer(base);
        this.dealer = new BlackjackPlayer(dealer);
    }

    public Blackjack(BasePlayer base, BasePlayer BJdealer, Console console) {

        while (isRunning) {
            this.player = new BlackjackPlayer(base);
            this.dealer = new BlackjackPlayer(BJdealer);
            betAmount = console.getIntegerInput("Please enter your wager");
            console.println(placeWager(betAmount));
            setupBoard();
            console.println("Dealer is dealt");
            console.print(Hand.showHand((ArrayList<Card>) dealer.hand));
            console.println("Player is dealt");
            console.print(Hand.showHand((ArrayList<Card>) player.hand));
            playerHandValue();
            while(playerTurn){
                String playerAnswer = console.getStringInput("Would you like to hit or stay?");
                checkPlayerAnswer(playerAnswer);
                console.println(playerAnswer);
                player.hand.add(super.draw());
                playerHandValue();
                console.print(playerHandValue.toString());
            }
            dealerTurn();

            console.print(Hand.showHand((ArrayList<Card>) dealer.hand));
            //console.println(test.toString());

        }
        }
        public Integer dealerTurn(){
        dealer.hand.add(super.draw());
        dealerHandValue();
        while(dealerHandValue() < 17){
            dealer.hand.add(super.draw());


        }
        return dealerHandValue;
        }
        public void checkPlayerAnswer(String playerAnswer){
        if(playerAnswer.toUpperCase().equals("HIT")){
            playerTurn = true;
            System.out.println(playerTurn);

        }else if(playerAnswer.toUpperCase().equals("STAY")){
            playerTurn = false;
            System.out.println(playerTurn);
        }
        }
        public void setupBoard(){
            player.setHand(super.deal(2));
            dealer.setHand(super.deal(1));


        }
        public Integer playerHandValue(){
            playerHandValue= 0;
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



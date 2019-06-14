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


    public  Blackjack(){}
    public Blackjack(BasePlayer base, BasePlayer dealer) {
        this.player = new BlackjackPlayer(base);
        this.dealer = new BlackjackPlayer(dealer);
    }
    public Blackjack(BasePlayer base, BasePlayer BJdealer, Console console){
        boolean isRunning = true;
        while(isRunning) {
            this.player = new BlackjackPlayer(base);
            this.dealer = new BlackjackPlayer(BJdealer);
            betAmount = console.getIntegerInput("Please enter your wager");
            console.println(placeWager(betAmount));
            setupBoard();
            console.println("Dealer is dealt");
            Hand.showHand((ArrayList<Card>) dealer.hand);
            console.println("Player is dealt");
            Hand.showHand((ArrayList<Card>) player.hand);
            Hand.


    }
    public void setupBoard(){
        player.setHand(super.deal(2));
        dealer.setHand(super.deal(1));


    }
    public String placeWager(){
        return null;
    }
    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {
        BasePlayer temp = new BasePlayer("test");
    }

    @Override
    public void welcomeMessage() {

    }


    public String placeWager(Integer betAmount) {
        String answer;
        this.betAmount = betAmount;
        if (player.getPlayer().removeFromWallet(betAmount)) {
            answer = "Bet Amount of " + betAmount + " Confirmed";

        } else {
            answer = "You currently do not have enough money to make that wager";
        }
        return answer;

}

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }
    public String placeWager(){
        return null;
    }
}
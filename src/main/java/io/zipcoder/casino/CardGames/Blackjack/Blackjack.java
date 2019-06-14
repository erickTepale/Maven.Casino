package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

public class Blackjack extends CardGame implements GamblingGame {
    private Integer minBet;
    private BlackjackPlayer player;
    private BlackjackPlayer dealer;
    private Integer betAmount;

    public Blackjack(BasePlayer base, BasePlayer dealer) {
        this.player = new BlackjackPlayer(base);
        this.dealer = new BlackjackPlayer(dealer);
    }
    public void main(){
        Console console = new Console(System.in, System.out);

        placeWager(console);
        player.setHand(super.deal(2));
        dealer.setHand(super.deal(1));



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

    public Integer placeWager(Console console) {
        console.getIntegerInput("Please enter your wager",betAmount);
        if(player.removeFromWallet(betAmount)){
            console.println("Bet Amount of " + betAmount + " Confirmed");

        }else{
            console.println("You currently do not have enough money to make that wager");
        }
        return betAmount;
    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }
    public Integer placeWager(){
        return null;
    }
}
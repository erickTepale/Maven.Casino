package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;

public class Poker extends CardGame implements GamblingGame {
    private PokerPlayer player;
    private PokerPlayer dealer;
    private Integer minBet;
    private Integer pot;
    private Integer[] wagerRecords; //2 rounds of betting
    private Console console;

    public Poker(BasePlayer player, BasePlayer dealer){
        super();
        this.player = new PokerPlayer(player);
        this.dealer = new PokerPlayer(dealer);
        this.pot = 0;
        this.minBet = 50;
        console = new Console(System.in, System.out);

        welcomeMessage();
        initGame();
    }

    private void initGame(){
        String action = "";
        //cycle through options
        do {
            switch (action) {
                case "quit":

            }

        }while(!action.equals("quit"));


        //place wager
    }

    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    public void printOptions(){
        //console.println();
    }


    //INTERFACE GAMBLING GAME METHODS
    @Override
    public void welcomeMessage() {
        console.println("Welcome to Blits and Chips Poker Room");
        console.println("Here At Blits and Chips we play Single Draw Poker ");

    }

    public Integer placeWager() {
        Integer bet = 0;
        console.getIntegerInput("Please input a wager(Min Bet: $" + minBet + ")", bet);
        return bet;
    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }

    // GETTERS
    public PokerPlayer getPlayer() {
        return player;
    }

    public PokerPlayer getDealer() {
        return dealer;
    }

    public Integer getMinBet() {
        return minBet;
    }

    public Integer getPot() {
        return pot;
    }

    public Integer[] getWagerRecords() {
        return wagerRecords;
    }
}
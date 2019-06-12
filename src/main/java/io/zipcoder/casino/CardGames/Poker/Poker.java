package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;

public class Poker extends CardGame implements GamblingGame {
    private PokerPlayer player;
    private PokerPlayer dealer;
    private Integer pot;
    private Deck deck;

    public Poker(BasePlayer player, BasePlayer dealer){
        this.player = new PokerPlayer(player);
        this.dealer = new PokerPlayer(dealer);
        deck = super.getDeck();
        pot = 0;
        initGame();
    }

    private void initGame(){

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
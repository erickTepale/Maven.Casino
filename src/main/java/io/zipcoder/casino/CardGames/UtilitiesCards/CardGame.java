package io.zipcoder.casino.CardGames.UtilitiesCards;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Game;

import java.util.ArrayList;
import java.util.Stack;

public abstract class CardGame extends Game {
    //does cardgame get deal and draw? or stay in deck
    private Deck deck;
    private BasePlayer basePlayer;
    private BasePlayer player;


    public CardGame() {
        deck = new Deck();
        deck.shuffle();
    }

    public ArrayList<Card> deal(Integer numOfCards){
        return Deck.getHand(numOfCards);
    }

    public Deck getDeck(){
        Deck a = new Deck();
        a.shuffle();
        return a;
    }

}
package io.zipcoder.casino.CardGames.UtilitiesCards;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Game;

import java.util.ArrayList;
import java.util.Stack;

public abstract class CardGame extends Game {
    //does cardgame get deal and draw? or stay in deck

    public ArrayList<Card> deal(Integer numOfCards){
        Deck deck = new Deck();
        deck.shuffle();

        return Deck.getHand(numOfCards);
    }

    public Deck getDeck(){
        Deck a = new Deck();
        a.shuffle();
        return a;
    }

}
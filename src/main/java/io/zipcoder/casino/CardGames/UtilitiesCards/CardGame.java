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
    private BasePlayer cpuPlayer;

    //working on deck methods
    public CardGame() {
        deck = new Deck();
        deck.shuffle();
    }

    public ArrayList<Card> deal(Integer numOfCards){
        return deck.getHand(numOfCards);
    }

    public Deck getDeck(){
        Deck a = new Deck();
        a.shuffle();
        return a;
    }

    public void add(Card card) {
        deck.add(card);
    }

    public void shuffle() {
        deck.shuffle();
    }

    public Integer getDeckSize() {
        return deck.getDeckSize();
    }

    public Integer getDiscardPileSize() {
        return deck.getDiscardPileSize();
    }

    public Card draw() {
        return deck.draw();
    }

    public Deck deckGetter(){
        return this.deck;
    }

    public void burn(Integer numberOfCards){
        deck.burn(numberOfCards);
    }


}
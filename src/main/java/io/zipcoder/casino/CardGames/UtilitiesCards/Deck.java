package io.zipcoder.casino.CardGames.UtilitiesCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    public Stack<Card> cards;
    public Stack<Card> discardPile;


    public Deck() {
        this.cards = new Stack<>();
        this.discardPile = new Stack<>();
        this.generate();
    }

    private void generate() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.push(new Card(suit, rank, suit.getSuitImage()));
            }
        }
    }

    public void add(Card card) {
        cards.push(card);
    }

    public Card draw() {
        return cards.pop();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void sortDeck(){
        Collections.sort(this.cards);
    }


    public Integer getDeckSize() {
        return cards.size();
    }

    public Integer getDiscardPileSize() {
        return discardPile.size();
    }


    public void burn(Integer numberOfCards){
        for (int i = 0; i < numberOfCards; i++) {
            discardPile.push(draw());
        }
    }

    public ArrayList<Card> getHand(Integer handSize){
        ArrayList<Card> thisHand = new ArrayList<Card>();
        for (int i = 0; i < handSize; i++){
            thisHand.add(draw());
        }
        return thisHand;
    }
}
package io.zipcoder.casino.CardGames.UtilitiesCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    public static Stack<Card> cards;
    public static Stack<Card> discardPile;


    public Deck() {
        this.cards = new Stack<Card>();
        this.discardPile = new Stack<Card>();
        this.generate();
    }

    public void generate() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.push(new Card(suit, rank));
            }
        }
    }

    public void add(Card card) {
        cards.push(card);
    }

    public static Card draw() {
        return cards.pop();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Integer getDeckSize() {
        return cards.size();
    }

    public Integer getDiscardPileSize() {
        return discardPile.size();
    }


    public static void burn(Integer numberOfCards){
        for (int i = 0; i < numberOfCards; i++) {
            discardPile.push(draw());
        }
    }

    public static ArrayList<Card> getHand(Integer handSize){
        ArrayList<Card> thisHand = new ArrayList<Card>();
        for (int i = 0; i < handSize; i++){
            thisHand.add(draw());
        }
        return thisHand;
    }
}
package io.zipcoder.casino.CardGames.UtilitiesCards;

import java.util.ArrayList;

public class Hand {
    public static ArrayList<Card> playerHand;
    public Deck thisDeck;

    public Hand(){
        this.playerHand = new ArrayList<Card>();
        this.thisDeck = new Deck();
    }

    public Hand(Integer handSize, Deck deck){
        for (int i = 0; i < handSize; i++){
            playerHand.add(deck.draw());
        }
    }

//    public void getHand(Integer handSize){
//        for (int i = 0; i < handSize; i++){
//            playerHand.add(thisDeck.draw());
//        }
//    }

}

package io.zipcoder.casino.CardGames.UtilitiesCards;

//import io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter.CardSorter;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> hand; // need to delete this asap

    public Hand(){
        this.hand = new ArrayList<>();
    }

    public Hand(ArrayList<Card> hand){
        this.hand = hand;
    }

    /*public static void showHand(){
        for (Card card: this.hand){
            System.out.println(card.printCard());
        }
    }*/

    public static void showHand(ArrayList<Card> hand){
        for (Card card: hand){
            System.out.println(card.printCard());
        }
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public Integer getHandSize(){
        return this.hand.size();
    }


    public void sortHandByNumber(){
        Collections.sort(this.hand);
    }

}

package io.zipcoder.casino.CardGames.UtilitiesCards;

//import io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter.CardSorter;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    public static ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<>();
    }

    public Hand(ArrayList<Card> hand){
        this.hand = hand;
    }

    public void showHand(){
        for (Card card: this.hand){
            System.out.println(card.printCard());
        }
    }


    public Integer getHandSize(){
        return this.hand.size();
    }


    public void sortHandByNumber(){
        Collections.sort(this.hand);
    }

//    public void sortHandByNumber(){
//        CardSorter(hand).sortCards();
//    }

}

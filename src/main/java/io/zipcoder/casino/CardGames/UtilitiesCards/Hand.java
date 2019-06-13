package io.zipcoder.casino.CardGames.UtilitiesCards;

//import io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter.CardSorter;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<>();
    }

    public Hand(ArrayList<Card> hand){
        this.hand = hand;
    }


    public String showHand(){
        String showHand = "";
        for (Card card: this.hand){
            showHand += card.printCard() + "\n";
            //System.out.println(card.printCard());
        }
        return showHand;
    }

    public void addToHand(Hand hand){
        for (Card card : hand.hand){
            this.hand.add(card);
        }
    }


    public Integer getHandSize(){
        return this.hand.size();
    }


    public void sortHandByNumber(){
        Collections.sort(this.hand);
    }

}

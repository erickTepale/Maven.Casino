package io.zipcoder.casino.CardGames.UtilitiesCards;

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
        }
        return showHand;
    }

    public void addToHand(Hand hand){
        for (Card card : hand.hand){
            this.hand.add(card);
        }
    }



    public ArrayList<Card> getHand() {
        return hand;
    }

    public Card getCard(Integer cardIndex) {
        return hand.get(cardIndex);
    }

    public String getCardStringValue(Integer cardIndex) {
        return hand.get(cardIndex).getFaceValue().getRankString();
    }




    public Integer getHandSize(){
        return this.hand.size();
    }


    public void sortHandByNumber(){
        Collections.sort(this.hand);
    }

}

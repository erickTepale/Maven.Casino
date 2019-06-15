package io.zipcoder.casino.CardGames.UtilitiesCards;


//import io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter.CardSorter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;

public class Hand {
    public static String showHand(ArrayList<Card> hand){
        String showHand = "";
        for (Card card: hand){
            showHand += "[" + card.printCard() + "] ";
        }
        return showHand;
    }

    public void addToHand(ArrayList<Card> hand){
        for (Card card : hand){
            hand.add(card);
        }
    }


    public void removeFromHand(ArrayList<Card> hand){
        for (Card card : hand){
            hand.add(card);
        }
    }

    public ArrayList<Card> getHand(ArrayList<Card> hand) {
        return hand;
    }


    public String getCardStringValue(Integer cardIndex, ArrayList<Card> hand) {
        return hand.get(cardIndex).getFaceValue().getRankString();
    }



    public Integer getHandSize(ArrayList<Card> hand){
        return hand.size();
    }


    public static void sortHandByNumber(ArrayList<Card> hand){
        Collections.sort(hand);
    }


    public static EnumMap<Rank, Integer> getHandMap(ArrayList<Card> hand){
        EnumMap<Rank, Integer> handMap = new EnumMap<>(Rank.class);
        for (Card card : hand){
            int count = handMap.containsKey(card.getFaceValue()) ? handMap.get(card.getFaceValue()) : 0;
            handMap.put(card.getFaceValue(), count + 1);
        }
        return handMap;
    }
}

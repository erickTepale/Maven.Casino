package io.zipcoder.casino.CardGames.UtilitiesCards;

//import io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter.CardSorter;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    public static void showHand(ArrayList<Card> hand){
        for (Card card: hand){
            System.out.println(card.printCard());
        }
    }

    public static void sortHandByNumber(ArrayList<Card> hand){
        Collections.sort(hand);
    }
}

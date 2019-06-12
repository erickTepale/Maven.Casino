package io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CardSorter {
    ArrayList<Card> cardsToSort;

    public CardSorter(ArrayList<Card> cardsToSort) {
        this.cardsToSort = cardsToSort;
    }

    public ArrayList<Card> sortCards(){
        Collections.sort(cardsToSort);
        return cardsToSort;
    }


}

package io.zipcoder.casino.CardGames.UtilitiesCards.CarSorter;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.Comparator;

public class CardCompare implements Comparator<Card> {

    public int compare(Card o1, Card o2) {
        return o1.getFaceValue().getRankValue() - o2.getFaceValue().getRankValue();
    }
}

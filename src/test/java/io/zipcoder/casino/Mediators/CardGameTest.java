package io.zipcoder.casino.Mediators;

import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CardGameTest extends CardGame{
    private Deck testDeck;
    private Hand testHand;

    @Before
    public void setup(){
        testDeck = new Deck();
        testHand = new Hand();
    }

    @Test
    public void testSize(){
        Integer expected = 52;
        testDeck = super.getDeck();

        Assert.assertEquals(expected, testDeck.getDeckSize());
    }

    @Test
    public void drawAndSizeTest(){
        Integer expected = 51;
        //Integer actual = testDeck.getDeckSize();
        //Assert.assertEquals(expected, actual);
    }

    @Test
    public void returnCardsFromDeck1(){


    }
}

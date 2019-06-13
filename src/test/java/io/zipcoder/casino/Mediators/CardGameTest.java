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
    private ArrayList<Card> testHand;

    public CardGameTest(){
        super();
    }

    @Before
    public void setup(){
        testDeck = super.getDeck();
        testHand = null;
    }

    @Test
    public void testSize(){
        Integer expected = 52;

        Assert.assertEquals(expected, testDeck.getDeckSize());
    }

    @Test
    public void burnTest(){
        Integer expected = 51;

        testDeck.burn(1);
        Integer actual = testDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealSizeTest1(){
        //expected
        Integer expected = 5;

        //action
        testHand = super.deal(5);
        Integer size = testHand.size();

        //check
        Assert.assertEquals(expected, size);
    }

    @Test
    public void dealSizeTest2(){
        //expected
        Integer expected = 25;

        //action
        testHand = super.deal(25);
        Integer size = testHand.size();

        //check
        Assert.assertEquals(expected, size);
    }

    @Test
    public void dealSizeTest3(){
        //expected
        Integer expected = 52;

        //action
        testHand = super.deal(52);
        Integer size = testHand.size();

        //check
        Assert.assertEquals(expected, size);
    }

    @Test
    public void addTest1(){
        //Card expected
        Card pop = super.draw();

        //action
        super.add(pop);

        Assert.assertEquals(pop, super.draw());
    }




}


package io.zipcoder.casino;

import io.zipcoder.casino.CardGames.UtilitiesCards.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class DeckTests {
    private Deck testDeck;
    private Hand testHand;

    @Before
    public void setup(){
        testDeck = new Deck();
        testHand = new Hand();
    }

    @Test
    public void sizeTest(){
        Integer expected = 52;
        Integer actual = testDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawAndSizeTest(){
        Integer expected = 51;
        testDeck.draw();
        Integer actual = testDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void DrawTest(){
        String expected = "King of Clubs";
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DrawTest2(){
        String expected = "Queen of Clubs";
        testDeck.draw();
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shuffleTest(){
        //test may fail ~1/52 times
        String unexpected = "Ace of Diamonds";
        testDeck.shuffle();
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertNotEquals(unexpected, actual);
    }


    @Test
    public void addCardTest(){
        String expected = "Ace of Diamonds";
        testDeck.draw();
        testDeck.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));
        Card thisCard = testDeck.cards.get(51);
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void discardTest(){
        String expected = "King of Clubs";
        testDeck.burn(1);
        String actual = testDeck.discardPile.peek().printCard();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void discardTest2(){
        Integer expected = 5;
        testDeck.burn(5);
        Integer actual = testDeck.getDiscardPileSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest(){
        testHand = new Hand(testDeck.getHand(7));
        Integer expected = 7;
        testHand.showHand(testHand.getHand());
        Integer actual = testHand.getHandSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest2(){
        testHand = new Hand(testDeck.getHand(35));
        testHand.sortHandByNumber();
        testHand.showHand(testHand.getHand());
//        Integer actual = testHand.getHandSize();
//        Assert.assertEquals(expected, actual);
    }

}


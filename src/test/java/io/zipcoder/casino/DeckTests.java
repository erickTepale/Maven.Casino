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
        String unexpected = "King of Clubs";
        while ((testDeck.cards.peek().printCard()).equals("King of Clubs")){
            testDeck.shuffle();
        }
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertNotEquals(unexpected, actual);
    }


    @Test
    public void addCardTest(){
        String expected = "Ace of Diamonds";
        testDeck.draw();
        testDeck.add(new Card(Suit.DIAMONDS, Rank.ACE));
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
    public void discardTest3(){
        Integer expected = 47;
        testDeck.burn(5);
        Integer actual = testDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void getHandTest(){
        testHand = new Hand(testDeck.getHand(7));
        Integer expected = 7;
        Integer actual = testHand.getHandSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest2(){
        testHand = new Hand(testDeck.getHand(10));
        Integer expected = 10;
        Integer actual = testHand.getHandSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest3(){
        testHand = new Hand(testDeck.getHand(10));
        Integer expected = 42;
        Integer actual = testDeck.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortHandTest(){
        String expected = "4 of Clubs\n" +
                "5 of Clubs\n" +
                "6 of Clubs\n" +
                "7 of Clubs\n" +
                "8 of Clubs\n" +
                "9 of Clubs\n" +
                "10 of Clubs\n" +
                "Jack of Clubs\n" +
                "Queen of Clubs\n" +
                "King of Clubs\n";
        testHand = new Hand(testDeck.getHand(10));
        testHand.sortHandByNumber();
        String actual = testHand.showHand();
        Assert.assertEquals(expected, actual);
    }

}

package io.zipcoder.casino;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.CardGames.UtilitiesCards.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DeckTests {
    private Deck testDeck;

    @Before
    public void setup(){
        testDeck = new Deck();
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
        String expected = "KING OF CLUBS";
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DrawTest2(){
        String expected = "QUEEN OF CLUBS";
        testDeck.draw();
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shuffleTest(){
        //test may fail ~1/52 times
        String unexpected = "ACE OF DIAMONDS";
        testDeck.shuffle();
        Card thisCard = testDeck.draw();
        String actual = thisCard.printCard();
        Assert.assertNotEquals(unexpected, actual);
    }


    @Test
    public void addCardTest(){
        String expected = "ACE OF DIAMONDS";
        testDeck.draw();
        testDeck.add(new Card(Suit.DIAMONDS, Rank.ACE));
        Card thisCard = testDeck.cards.get(51);
        String actual = thisCard.printCard();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void discardTest(){
        String expected = "KING OF CLUBS";
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
}

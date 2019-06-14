package io.zipcoder.casino;

import io.zipcoder.casino.CardGames.GoFish.GoFish;
import io.zipcoder.casino.CardGames.GoFish.GoFishPlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishTests {

    private GoFish goFishGame;
    private BasePlayer basePlayer;
    private GoFishPlayer humanPlayer;
    private GoFishPlayer cpuPlayer;

    @Before
    public void setup(){
        basePlayer = new BasePlayer("Test");
        humanPlayer = new GoFishPlayer(basePlayer);
        cpuPlayer = new GoFishPlayer();
        goFishGame = new GoFish(basePlayer, cpuPlayer);
        goFishGame.deckGetter().sortDeck();
    }

    @Test
    public void deckSizeTest(){
        Integer expected = 52;
        Integer actual = goFishGame.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deckSizeTest2(){
        Integer expected = 38;
        goFishGame.setHand(humanPlayer);
        goFishGame.setHand(cpuPlayer);
        Integer actual = goFishGame.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest(){
        Integer expected = 7;
        goFishGame.setHand(humanPlayer);
        Integer actual = humanPlayer.hand.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest2(){
        Integer expected = 7;
        goFishGame.setHand(cpuPlayer);
        Integer actual = cpuPlayer.hand.size();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void handMapTest(){
        goFishGame.setHand(cpuPlayer);
        System.out.println(Hand.showHand(cpuPlayer.hand));
        System.out.println(Hand.getHandMap(cpuPlayer.hand));

    }

    @Test
    public void getBookTest(){
        goFishGame.setHand(cpuPlayer);
        goFishGame.checkForBooks(cpuPlayer);

        Integer expectedHandSize = 3;
        Integer actualHandSize = cpuPlayer.hand.size();

        Integer expectedBooks = 1;
        Integer actualBooks = cpuPlayer.getNumberOfBooks();

        Assert.assertEquals(expectedHandSize, actualHandSize);
        Assert.assertEquals(expectedBooks, actualBooks);
    }






//    @Test
//    public void sortHandTest(){
//        goFishGame.setHand(humanPlayer);
//        humanPlayer.hand.size();
//
//        Assert.assertTrue(humanPlayer.hand.getCardStringValue(0) == "Queen" &&
//                humanPlayer.hand.getCardStringValue(1) == "Queen"
//                && humanPlayer.hand.getCardStringValue(2) == "Queen"
//                && humanPlayer.hand.getCardStringValue(3) == "King"
//                && humanPlayer.hand.getCardStringValue(4) == "King"
//                && humanPlayer.hand.getCardStringValue(5) == "King"
//                && humanPlayer.hand.getCardStringValue(6) == "King");
//    }
//
//    @Test
//    public void sortHandTest2(){
//        goFishGame.setHand(humanPlayer);
//        goFishGame.setHand(cpuPlayer);
//        cpuPlayer.hand.sortHandByNumber();
//
//        Assert.assertTrue(cpuPlayer.hand.getCardStringValue(0) == "Ten" &&
//                cpuPlayer.hand.getCardStringValue(1) == "Ten"
//                && cpuPlayer.hand.getCardStringValue(2) == "Jack"
//                && cpuPlayer.hand.getCardStringValue(3) == "Jack"
//                && cpuPlayer.hand.getCardStringValue(4) == "Jack"
//                && cpuPlayer.hand.getCardStringValue(5) == "Jack"
//                && cpuPlayer.hand.getCardStringValue(6) == "Queen");
//    }


//    @Test
//    public void getNameTest(){
//        String expected = "Test";
//        String actual = humanPlayer.getName();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getNameTest2(){
//        String expected = "Go Fish Player";
//        String actual = cpuPlayer.getName();
//        Assert.assertEquals(expected, actual);
//    }


}

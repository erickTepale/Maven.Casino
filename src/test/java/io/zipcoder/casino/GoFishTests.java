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
    private Console console;

    @Before
    public void setup(){
        basePlayer = new BasePlayer("Test");
        humanPlayer = new GoFishPlayer(basePlayer);
        console = new Console(System.in, System.out);
        cpuPlayer = new GoFishPlayer();
        goFishGame = new GoFish(basePlayer, cpuPlayer);
        goFishGame.deckGetter().sortDeck();
        goFishGame.setHand(humanPlayer);
        goFishGame.setHand(cpuPlayer);
    }

    @Test
    public void deckSizeTest(){
        GoFish testGoFishGame = new GoFish(basePlayer, cpuPlayer);
        Integer expected = 52;
        Integer actual = testGoFishGame.getDeckSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deckSizeTest2(){
        Integer expected = 38;
        Integer actual = goFishGame.getDeckSize();
        Assert.assertEquals(expected, actual);
    }




    @Test
    public void getHandTest(){
        Integer expected = 7;
        Integer actual = humanPlayer.hand.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest2(){
        Integer expected = 7;
        Integer actual = cpuPlayer.hand.size();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void handMapTest(){
        System.out.println(Hand.showHand(cpuPlayer.hand));
        System.out.println(Hand.getHandMap(cpuPlayer.hand));

    }

    @Test
    public void getBookTest(){
        goFishGame.checkForBooks(cpuPlayer);

        Integer expectedHandSize = 3;
        Integer actualHandSize = cpuPlayer.hand.size();

        Integer expectedBooks = 1;
        Integer actualBooks = cpuPlayer.getNumberOfBooks();

        Assert.assertEquals(expectedHandSize, actualHandSize);
        Assert.assertEquals(expectedBooks, actualBooks);
    }



    @Test
    public void doTurnTest(){
        Integer expectedInitialHandSize = 7;
        Integer actualInitialHandSize = humanPlayer.hand.size();


        goFishGame.doTurn(humanPlayer, cpuPlayer, "JACK");

        Integer expectedResultingHandSize = 11;
        Integer actualResultingHandSize = humanPlayer.hand.size();

        Assert.assertEquals(expectedInitialHandSize, actualInitialHandSize);
        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);

    }

    @Test
    public void doTurnTest3(){
        Integer expectedInitialHandSize = 7;
        Integer actualInitialHandSize = cpuPlayer.hand.size();

        goFishGame.doTurn(humanPlayer, cpuPlayer, "JACK");

        Integer expectedResultingHandSize = 3;
        Integer actualResultingHandSize = cpuPlayer.hand.size();

        Assert.assertEquals(expectedInitialHandSize, actualInitialHandSize);
        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);
    }


    @Test
    public void doTurnTest4(){
        Integer expectedInitialHandSize = 7;
        Integer actualInitialHandSize = cpuPlayer.hand.size();

        goFishGame.doTurn(cpuPlayer, humanPlayer, "KING");

        Integer expectedResultingHandSize = 11;
        Integer actualResultingHandSize = cpuPlayer.hand.size();

        Assert.assertEquals(expectedInitialHandSize, actualInitialHandSize);
        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);
    }
    @Test
    public void doTurnTest5(){
        goFishGame.doTurn(cpuPlayer, humanPlayer, "THREE");

        Integer expectedResultingHandSize = 8;
        Integer actualResultingHandSize = cpuPlayer.hand.size();

        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);
    }

    @Test
    public void goFishTest(){
        goFishGame.goFish(humanPlayer);

        Integer expectedResultingHandSize = 8;
        Integer actualResultingHandSize = humanPlayer.hand.size();

        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);

        Integer inspectahDeck = 37;
        Integer protectYahDeck = goFishGame.getDeckSize();
        Assert.assertEquals(inspectahDeck, protectYahDeck);
    }

    @Test
    public void goFishTest2(){
        goFishGame.goFish(humanPlayer);
        goFishGame.goFish(humanPlayer);
        goFishGame.goFish(humanPlayer);

        Integer expectedResultingHandSize = 10;
        Integer actualResultingHandSize = humanPlayer.hand.size();

        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);

        Integer inspectahDeck = 35;
        Integer protectYahDeck = goFishGame.getDeckSize();
        Assert.assertEquals(inspectahDeck, protectYahDeck);
    }

    @Test
    public void goFishNameTest(){
        String expected = "Test";
        String actual = goFishGame.basePlayer.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void goFishWalletTest(){
        Integer expected= 100000;
        Integer actual = goFishGame.basePlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }









}

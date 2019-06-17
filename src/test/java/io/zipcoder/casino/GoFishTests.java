package io.zipcoder.casino;

import com.sun.source.tree.AssertTree;
import io.zipcoder.casino.CardGames.GoFish.GoFish;
import io.zipcoder.casino.CardGames.GoFish.GoFishPlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

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
        EnumMap<Rank, Integer> playerMap = Hand.getHandMap(cpuPlayer.hand);

        Assert.assertTrue(playerMap.containsKey(Rank.TEN));
        Assert.assertTrue(playerMap.containsKey(Rank.JACK));
        Assert.assertTrue(playerMap.containsKey(Rank.QUEEN));
    }

    @Test
    public void handMapTest2(){
        EnumMap<Rank, Integer> playerMap = Hand.getHandMap(humanPlayer.hand);

        Assert.assertTrue(playerMap.containsKey(Rank.KING));
        Assert.assertTrue(playerMap.containsKey(Rank.QUEEN));
    }

    @Test
    public void showHandTest(){
        String expected = "[10❤] [10♠] [J♣] [J♦] [J❤] [J♠] [Q♣] ";
        Hand.sortHandByNumber(cpuPlayer.hand);
        String actual = Hand.showHand(cpuPlayer.hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showHandTest2(){
        String expected = "[Q♦] [Q❤] [Q♠] [K♣] [K♦] [K❤] [K♠] ";
        Hand.sortHandByNumber(humanPlayer.hand);
        String actual = Hand.showHand(humanPlayer.hand);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printHandTest(){
        String expected = "\n" +
                "\n" +
                "          Test's Hand:\n" +
                "===================================\n" +
                "[Q♦] [Q❤] [Q♠] [K♣] [K♦] [K❤] [K♠] \n" +
                "===================================\n" +
                "You have 0 books.\n" +
                "Your opponent has 0 books.";
        Hand.sortHandByNumber(humanPlayer.hand);
        String actual = goFishGame.printHand(humanPlayer);

        //Assert.assertEquals(expected, actual);
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
    public void doTurnTest6() {
        goFishGame.doTurn(cpuPlayer, humanPlayer, "THREE");
        goFishGame.doTurn(humanPlayer, cpuPlayer, "DEUCE");

        Integer inspectahDeck = 36;
        Integer protectYahDeck = goFishGame.getDeckSize();

        Assert.assertEquals(inspectahDeck, protectYahDeck);
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
    public void checkForBooksTest(){
        goFishGame.checkForBooks(humanPlayer);

        Integer expectedResultingHandSize = 3;
        Integer actualResultingHandSize = humanPlayer.hand.size();

        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);
    }

    @Test
    public void checkForBooksTest2(){
        goFishGame.checkForBooks(cpuPlayer);

        Integer expectedResultingHandSize = 3;
        Integer actualResultingHandSize = cpuPlayer.hand.size();

        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);
    }

    @Test
    public void checkForWinTest(){
        goFishGame.cpuPlayer.setNumberOfBooks(13);
        Assert.assertTrue(goFishGame.checkWin());
    }

    @Test
    public void checkForWinTest2(){
        goFishGame.cpuPlayer.setNumberOfBooks(12);
        Assert.assertFalse(goFishGame.checkWin());
    }

    @Test
    public void checkHandTest(){
        goFishGame.doTurn(humanPlayer, cpuPlayer, "QUEEN");
        goFishGame.checkForBooks(humanPlayer);

        Integer expectedInitialHandSize = 0;
        Integer actualInitialHandSize = humanPlayer.hand.size();

        goFishGame.checkHand(humanPlayer);

        Integer expectedResultingHandSize = 1;
        Integer actualResultingHandSize = humanPlayer.hand.size();


        Assert.assertEquals(expectedInitialHandSize, actualInitialHandSize);
        Assert.assertEquals(expectedResultingHandSize, actualResultingHandSize);

    }




    @Test
    public void goFishNameTest(){
        String expected = "Test";
        String actual = goFishGame.basePlayer.getName();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void setUpTest() {
        goFishGame.setUp();
        Integer expected = 3;
        Integer actual= cpuPlayer.hand.size();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void goFishWalletTest(){
        Integer expected= 100000;
        Integer actual = goFishGame.basePlayer.getWallet();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void printRulesTest(){
        String expected= "\nA 'book' is a pair of four cards, based only on value (suit can be disregarded)." +
                "\nOn your turn, you may choose a card and ask the opponent if they have any of that card." +
                "\nIf they do, they must give you all of their cards of that type." +
                "\nIf they don't have any, then you 'go fish'! (Draw a card from the deck)." +
                "\nThe game is played until there are no cards remaining in the deck, or a player runs out of cards." +
                "\nThe player with the most books at the end of the game wins!";
//        String actual = goFishGame.printRules();
//
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printMenuTest(){
        String expected= "\nPlease Type In An Option: " +
                "\nPlay:              [Play]" +
                "\nSee Rules:         [Rules]" +
                "\nReturn to Lobby:   [Quit]";
        String actual = goFishGame.printMenu();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerTurnTest(){
        Rank expected= Rank.JACK;
        Rank actual = goFishGame.playerTurn();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cpuTurnTest(){
        String expected = "JACK";
        String actual = goFishGame.cpuTurn();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playGameTest(){
        goFishGame.playGame();
        String expected = "JACK";
        String actual = goFishGame.cpuTurn();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest(){
//        GoFish goFishGame2 = new GoFish(basePlayer, cpuPlayer, new Console(System.in, System.out));
//        String expected = "Test";
//        String actual = goFishGame2.basePlayer.getName();
//        Assert.assertEquals(expected, actual);
    }


    @Test
    public void startGameTest(){
        //goFishGame.startGame();

        Integer expected = 7;
        Integer actual = goFishGame.cpuPlayer.hand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCPUChoiceTest(){
        String expected = "JACK";
        String actual = goFishGame.cpuTurn();

        Assert.assertEquals(expected, actual);
    }








}

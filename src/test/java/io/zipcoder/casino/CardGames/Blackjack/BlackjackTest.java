package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackTest {
public BasePlayer base;
public BasePlayer dealer;
public BlackjackPlayer player;
    @Test
    public void isAcePresent(){
        //deck.compare("ACE");


    }
    @Test
    public void areTwoCardsDrawn(){
        //getHandSize
    }
    @Test
    public void canPlayerHitonBust(){
        // Deck deck = new deck
        //
    }
    @Test
    public void canDealerBust(){}
    @Test
    public void isWin() {

    }

    @Test
    public void switchTurns() {
    }

    @Test
    public void welcomeMessage() {
    }

    @Test
    public void testplaceWager() {
        base.getWallet();
        Blackjack bj = new Blackjack(base,dealer);

        Integer betAmount = 100;


        System.out.println(base.getWallet());
        String answer = bj.placeWager(100);



        String expected = "Bet Amount of " + betAmount + " Confirmed";;

        Assert.assertEquals(expected,answer);



    }

    @Test
    public void increaseMinBet() {
    }

    @Test
    public void decreaseMinBet() {
    }
}
package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackTest {
public BasePlayer base;
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
    public void placeWager(Integer betAmount) {
        BasePlayer base = new BasePlayer();
        BasePlayer player = new BlackjackPlayer(base);
        String answer = player.placeWager(100);


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
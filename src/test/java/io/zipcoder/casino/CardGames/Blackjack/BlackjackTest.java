package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

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

        String expected = "Bet Amount of " + betAmount + " Confirmed";;

        Assert.assertEquals(expected,placeWager(betAmount));

    }

    @Test
    public void increaseMinBet() {
    }

    @Test
    public void decreaseMinBet() {
    }
}
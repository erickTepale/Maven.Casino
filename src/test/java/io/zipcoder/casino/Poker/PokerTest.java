package io.zipcoder.casino.Poker;

import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokerTest {
    private BasePlayer player;
    private BasePlayer dealer;
    @Before
    public void setup(){
        player = new BasePlayer();
        dealer = new BasePlayer();
    }



    @Test
    public void constructorTest1(){
        //expected
        Integer pot = 0;

        //action
        //Poker a = new Poker(player, dealer, console);

        //result
        //Assert.assertEquals(pot, a.getPot());
    }
    @Test
    public void constructorTest2(){
        //expected
        Integer minBet = 0;

        //action
        //Poker a = new Poker(player, dealer);

        //result
        //Assert.assertEquals(minBet, a.getPot());
    }

}

package io.zipcoder.casino.Poker;

import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.ConsoleIO;
import io.zipcoder.casino.utilities.TestConsole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PokerTest {
    private BasePlayer player;
    private BasePlayer dealer;
    private ConsoleIO console;
    private ArrayList<String> expected;

    @Before
    public void setup(){
        expected = new ArrayList<>();
        player = new BasePlayer();
        dealer = new BasePlayer();
        //console = new TestConsole(expected);
    }



    @Test
    public void constructorTest1(){
        //expected insert input
        String ab = "Welcome to Blits and Chips Poker Room\n";
        String b = "Here At Blits and Chips we play Single Draw Poker\n";
        expected.add(ab + b);
        expected.add("");

        console = new TestConsole(expected);

        //expected
        Integer pot = 0;

        //action
        Poker a = new Poker(player, dealer, console);

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

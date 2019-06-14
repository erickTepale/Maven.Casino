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


}

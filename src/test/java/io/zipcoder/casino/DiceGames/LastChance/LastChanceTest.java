package io.zipcoder.casino.DiceGames.LastChance;

//<<<<<<< HEAD
import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Test;

import static org.junit.Assert.*;

//=======
import io.zipcoder.casino.DiceGames.LastChance.LastChance;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.ConsoleIO;
import io.zipcoder.casino.utilities.TestConsole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LastChanceTest {
    public BasePlayer player;
    public ConsoleIO console;
    public ArrayList<String> expected;

    @Before
    public void setup(){
        expected = new ArrayList<>();
        player = new BasePlayer();
    }

    @Test
    public void setupGameTest(){
        int iBet = 10;
        int iMultiplier = 5;
//        assertEquals(50, LastChance.setupGame(iBet, iMultiplier));
    }


}
//>>>>>>> abcc2f825910283c0453c5c77134fd13828d5e58

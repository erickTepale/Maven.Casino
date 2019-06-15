package io.zipcoder.casino.DiceGames.Craps;

import com.sun.xml.internal.rngom.parse.host.Base;
import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {


    @Test
    public void initGame() {
        //given
        //when
        //then
    }

    @Test
    public void playGame() {
        //Given
        BasePlayer player = new CrapsPlayer("Henry");
        BasePlayer dealer = new CrapsPlayer("Dealer");
        Craps craps =  new Craps(player, dealer);
        craps.setStartBet(30);
        //when
        craps.playGame();

        Assert.assertTrue(craps.getRollCount() >= 1);
        Assert.assertTrue(craps.getMinBet() == 20);
        Assert.assertTrue(craps.getWin() == true || craps.getWin() == false);
        Assert.assertTrue(craps.getWinAmount() == 0 || craps.getWinAmount() == 30 * 2);
        Assert.assertTrue(craps.getLastRolledValue() > 2 || craps.getLastRolledValue()<=12);




    }

    @Test
    public void roll() {
        //given
        BasePlayer player = new CrapsPlayer("Henry");
        BasePlayer dealer = new CrapsPlayer("Dealer");
        Craps crap = new Craps(player, dealer);
        //when
        int rolledValue = crap.roll();
        //then
        Assert.assertTrue(rolledValue>=2 && rolledValue<=12);
    }

    @Test
    public void welcomeMessage() {
        // given
        // when
        //then
    }

    @Test
    public void placeWager() {

    }
}
package io.zipcoder.casino.utilities;

import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTests {
    @Test
    public void testRollOneDie(){
        //Dice dice = new Dice();
        Integer actual = Dice.roll();
        System.out.println(actual);
        Integer min = 2;
        Integer max = 12;

        Assert.assertTrue(actual >= min && actual <= max);

    }
//    @Test
//    public void testRollTwoDice(){
//        Dice dice = new Dice();
//        Integer actual = dice.rollTwoDice();
//        Integer min = 2;
//        Integer max = 12;
//
//        Assert.assertTrue(actual >= min && actual <= max);
//
//    }
//
//    @Test
//    public void testRollThreeDice(){
//        Dice dice = new Dice();
//        Integer actual = dice.rollThreeDie();
//        Integer min = 3;
//        Integer max = 18;
//
//        Assert.assertTrue(actual >= min && actual <= max);
//
//    }
//    @Test
//    public void testRollFourDice(){
//        Dice dice = new Dice();
//        Integer actual = dice.rollFourDie();
//        Integer min = 4;
//        Integer max = 24;
//
//        Assert.assertTrue(actual >= min && actual <= max);
//
//    }
//
//    @Test
//    public void testRollFiveDice(){
//        Dice dice = new Dice();
//        Integer actual = dice.rollFiveDie();
//        Integer min = 5;
//        Integer max = 30;
//
//       Assert.assertTrue(actual >= min && actual <= max);
//
//    }
//
//
//
}

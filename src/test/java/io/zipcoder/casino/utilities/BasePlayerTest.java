package io.zipcoder.casino.utilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasePlayerTest {

    @Test
    public void getName() {

        BasePlayer test = new BasePlayer("Test");

        assertEquals("Test",test.getName());

    }

    @Test
    public void addMoneyTest1(){
        BasePlayer a = new BasePlayer("bleh");

        //expected
        Integer expected= 100100;

        //action
        a.addToWallet(100);

        Assert.assertEquals(expected, a.getWallet());
    }

    @Test
    public void subtractMoneyTest1(){
        BasePlayer a = new BasePlayer("bleh");

        //expected
        Integer expected= 50000;

        //action
        Assert.assertTrue(a.removeFromWallet(50000));;

        Assert.assertEquals(expected, a.getWallet());

    }

    @Test
    public void subtractMoneyTest2(){
        BasePlayer a = new BasePlayer("bleh");

        //expected
        Integer expected= 0;

        //action
        Assert.assertTrue(a.removeFromWallet(100000));;

        Assert.assertEquals(expected, a.getWallet());

    }

    @Test
    public void subtractMoneyTest3(){
        BasePlayer a = new BasePlayer("bleh");

        //expected
        Integer expected= 100000;

        //action
        Assert.assertFalse(a.removeFromWallet(100001));;

        Assert.assertEquals(expected, a.getWallet());

    }

    @Test
    public void subtractMoneyTest4(){
        BasePlayer a = new BasePlayer("bleh");

        //expected
        Integer expected= 100000;

        //action
        Assert.assertFalse(a.removeFromWallet(5000000));;

        Assert.assertEquals(expected, a.getWallet());

    }

    @Test
    public void ownerTest1(){
        BasePlayer a = new BasePlayer("bleh");
        Assert.assertFalse(a.getOwner());
    }

    @Test
    public void ownerTest2(){
        BasePlayer a = new BasePlayer("bleh");
        a.setOwner(true);
        Assert.assertTrue(a.getOwner());
    }

    @Test
    public void printCharTest(){
        BasePlayer a = new BasePlayer("bleh");
        Console console = new Console(System.in, System.out);
        String expected = "====================\nName: " + a.getName() + "\nCash: $" + a.getWallet() + "\n====================";
        String actual = a.printChar(console);
        Assert.assertEquals(expected, actual);
    }


}
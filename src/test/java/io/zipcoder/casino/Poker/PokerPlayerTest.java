package io.zipcoder.casino.Poker;

import io.zipcoder.casino.CardGames.Poker.PokerPlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.*;
import io.zipcoder.casino.utilities.BasePlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Suite;

import java.util.ArrayList;

public class PokerPlayerTest {

    @Test
    public void checkRoyalTest1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);
        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        realPlayer.setHand(hand);

        Assert.assertTrue(realPlayer.checkRoyal());

    }
    @Test
    public void checkRoyalTest2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();



        hand.add(new Card(Suit.CLUBS, Rank.ACE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);

        Assert.assertTrue(realPlayer.checkRoyal());
    }

    @Test
    public void checkRoyalTest3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();



        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);

        Assert.assertFalse(realPlayer.checkRoyal());

    }

    @Test
    public void checkStraightTest1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.ACE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);

        Assert.assertTrue(realPlayer.checkStraight());

    }

    @Test
    public void checkStraightTest2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.SIX,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.EIGHT,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.NINE, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkStraight());

    }

    @Test
    public void checkStraightTest3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.FOUR,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.EIGHT,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.NINE, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkStraight());

    }

    @Test
    public void checkFlushTest1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.CLUBS, Rank.DEUCE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkFlush());

    }

    @Test
    public void checkFlushTest2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.DEUCE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN,  Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkFlush());

    }

    @Test
    public void checkFlushTest3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.DEUCE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkFlush());

    }

    @Test
    public void check3Kind1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.DEUCE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.DEUCE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.DEUCE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.check3Kind());

    }

    @Test
    public void check3Kind2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.ACE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.FOUR,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.FOUR,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.check3Kind());

    }

    @Test
    public void check3Kind3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.KING,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.check3Kind());

    }

    @Test
    public void check4Kind1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.check4Kind());

    }

    @Test
    public void check4Kind2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.THREE, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.check4Kind());

    }
    @Test
    public void check4Kind3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.check4Kind());

    }


    @Test
    public void checkBoat1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkBoat());

    }

    @Test
    public void checkBoat2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.THREE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkBoat());

    }

    @Test
    public void checkBoat3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkBoat());

    }

    @Test
    public void check2Pair1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.THREE,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.THREE,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.ACE,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkTwoPair());

    }

    @Test
    public void check2Pair2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.FOUR,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkTwoPair());

    }

    @Test
    public void check2Pair3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.FOUR,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.SEVEN, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkTwoPair());

    }

    @Test
    public void checkPair1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkPair());

    }

    @Test
    public void checkPair2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.EIGHT,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.checkPair());

    }

    @Test
    public void checkPair3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.QUEEN,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.EIGHT,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.checkPair());

    }

    @Test
    public void testQHigh1(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.QHigh());

    }

    @Test
    public void testQHigh2(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.SIX,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertFalse(realPlayer.QHigh());

    }

    @Test
    public void testQHigh3(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.QHigh());

    }


    @Test
    public void testQHigh4(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);
        System.out.println(Hand.showHand((ArrayList<Card>) realPlayer.getHand()));

        Assert.assertTrue(realPlayer.QHigh());

    }

    @Test
    public void testPlaceWager1(){
        BasePlayer play = new BasePlayer("name");
        PokerPlayer player = new PokerPlayer(play);

        //expected
        Integer expected = player.getPlayer().getWallet() - 100;
        System.out.println(expected);

        //action
        player.placeWager(100);


        //actual
        Assert.assertEquals(expected, player.getPlayer().getWallet());

    }

    @Test
    public void testPlaceWager2(){
        BasePlayer play = new BasePlayer("name");
        PokerPlayer player = new PokerPlayer(play);

        //expected
        Integer expected = player.getPlayer().getWallet() - 10000;
        System.out.println(expected);

        //action
        player.placeWager(10000);


        //actual
        Assert.assertEquals(expected, player.getPlayer().getWallet());

    }

    @Test
    public void testPlaceWager3(){
        BasePlayer play = new BasePlayer("name");
        PokerPlayer player = new PokerPlayer(play);

        //expected
        Integer expected = player.getPlayer().getWallet();
        System.out.println(expected);

        //action
        player.placeWager(200001);


        //actual
        Assert.assertEquals(expected, player.getPlayer().getWallet());

    }

    @Test
    public void testAddHand(){
        BasePlayer player = new BasePlayer();
        PokerPlayer realPlayer = new PokerPlayer(player);

        ArrayList<Card> hand = new ArrayList<>();

        hand.add(new Card(Suit.SPADES, Rank.EIGHT,   Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SEVEN,   Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE,  Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.FOUR, Suit.SPADES.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK,  Suit.CLUBS.getSuitImage()));

        realPlayer.setHand(hand);

        //expected
        Integer expected = realPlayer.getHand().size() + 1;

        //action
        realPlayer.addCard(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        Assert.assertEquals(expected,Integer.valueOf( realPlayer.getHand().size()));
    }

}

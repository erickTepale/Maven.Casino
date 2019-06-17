package io.zipcoder.casino.Poker;

import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.CardGames.UtilitiesCards.Suit;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Optional.*;

public class PokerTest {
    private BasePlayer player;
    private BasePlayer dealer;
    private Console console;
    private ArrayList<String> expected;
    private Poker pokerGame ;

    @Before
    public void setup(){
        this.player = new BasePlayer("player");
        this.dealer = new BasePlayer("player");
        console = new Console(System.in, System.out);
      this.pokerGame = new Poker(player, dealer, console);
    }


    @Test
    public void constructorTest(){
        Assert.assertEquals(pokerGame.getPot(), Integer.valueOf(0));
        Assert.assertFalse(pokerGame.getFold());
        Assert.assertEquals(50, (int) pokerGame.getMinBet());
    }

    @Test
    public void dealTest(){
        pokerGame.deal();

        Assert.assertEquals(pokerGame.getDealer().getHand().size(), 5);
        Assert.assertEquals(pokerGame.getPlayer().getHand().size(), 5);
    }

    @Test
    public void testSort(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));


        pokerGame.getPlayer().setHand(hand);

        //action
        pokerGame.sortHands();

        Assert.assertEquals(pokerGame.getPlayer().getHand().get(0).getFaceValue().getRankValue(), 1);
    }

    @Test
    public void testReAdd(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));


        pokerGame.getPlayer().setHand(hand);
        pokerGame.setDiscard(new Integer[]{1, 2});

        pokerGame.reAdd();

        Assert.assertEquals(pokerGame.getPlayer().getHand().size(), 7);


    }

    @Test
    public void parseDiscardInput(){
        Assert.assertTrue(pokerGame.parseDiscardInput("asda"));
    }

    @Test
    public void parseDiscardInput1(){
        Assert.assertFalse(pokerGame.parseDiscardInput("4"));
    }

    @Test
    public void testCheckWinner(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.HEARTS, Rank.NINE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        //action
        pokerGame.checkWinner();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(110020), pokerGame.getPlayer().getPlayer().getWallet());
    }

    @Test
    public void testCheckWinner2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.HEARTS, Rank.NINE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);

        //action
        pokerGame.checkWinner();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(100010), pokerGame.getDealer().getPlayer().getWallet());
    }

    ////// Player wins Tied Hands methods : who wins when both have 2pair etc not exactly same 2 pair...
    @Test
    public void testPlayerWinsHighHand(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SIX, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.FIVE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.FIVE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(1), pokerGame.playerWinsHighCard());
    }
    @Test
    public void testPlayerWinsHighHand1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.SIX, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.FIVE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.FIVE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);


        // assert pay player
        Assert.assertEquals(Integer.valueOf(-1), pokerGame.playerWinsHighCard());
    }

    @Test
    public void testPlayerWins2Pair(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.FIVE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.FIVE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.FIVE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.FIVE, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(0), pokerGame.playerWins2Pair());
    }

    @Test
    public void testPlayerWins2Pair1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.DEUCE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.FIVE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.FIVE, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(0), pokerGame.playerWins2Pair());
    }

    @Test
    public void testPlayerWins2Pair2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(0), pokerGame.playerWins2Pair());
    }

    @Test
    public void testPlayerWins1Pair1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(1), pokerGame.playerWinPair());
    }

    @Test
    public void testPlayerWins1Pair2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(-1), pokerGame.playerWinPair());
    }

    @Test
    public void testPlayerWins1Pair3(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.ACE, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(0), pokerGame.playerWinPair());
    }

    @Test
    public void testPlayerWinsFullHouse1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(1), pokerGame.playerWinFullHouse());
    }

    @Test
    public void testPlayerWinsKicker1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.SEVEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.FIVE, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(1),pokerGame.playerWinsKicker());
    }

    @Test
    public void testPlayerWinsKicker3(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.TEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(1),pokerGame.playerWinsKicker());
    }

    @Test
    public void testPlayerWinsKicker4(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.TEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(-1),pokerGame.playerWinsKicker());
    }

    @Test
    public void testInit(){
        Assert.assertEquals(pokerGame.getPot(), Integer.valueOf(0));
        Assert.assertFalse(pokerGame.getFold());
        Assert.assertEquals(50, (int) pokerGame.getMinBet());
        pokerGame.initGame("Quit");
    }

    @Test
    public void testPlayerWinsKicker5(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.TEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        pokerGame.getPlayer().setHand(hand);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(0),pokerGame.playerWinsKicker());
    }


    @Test
    public void testPlayerWinsFourKind1(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertTrue(pokerGame.playerWinFourKind());
    }

    @Test
    public void testPlayerWinsFourKind2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.KING, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.KING, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.KING, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertFalse(pokerGame.playerWinFourKind());
    }


    @Test
    public void testPlayerWinsFullHouse2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(-1), pokerGame.playerWinFullHouse());
    }

    @Test
    public void testPlayerWinsFullHouse3(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.KING, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.KING, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        // assert pay player
        Assert.assertEquals(Integer.valueOf(-1), pokerGame.playerWinFullHouse());
    }

    @Test
    public void testCompareWinnerByLastCard1(){ //flush
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.DEUCE, Suit.CLUBS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.SEVEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.FIVE, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.EIGHT, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.FOUR, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();



        // assert pay player
        Assert.assertEquals(pokerGame.getPlayer().getPlayer().getWallet(), Integer.valueOf(100150));
    }

    @Test
    public void testCompareWinnerByLastCard2(){ // flush
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.ACE, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.DEUCE, Suit.CLUBS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.SEVEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.DEUCE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();



        // assert pay player
        Assert.assertEquals(Integer.valueOf(100010), pokerGame.getPlayer().getPlayer().getWallet());
    }

    @Test
    public void testCompareWinnerByLastCard3(){ // Straight
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.CLUBS, Rank.KING, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();



        // assert pay player
        Assert.assertEquals(Integer.valueOf(100110), pokerGame.getPlayer().getPlayer().getWallet());
    }

    @Test
    public void testDisplayLost(){
        pokerGame.displayLost();

        Assert.assertTrue(pokerGame.getFold());


    }

    @Test
    public void testCompareWinnerByLastCard4(){ // Straight
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.CLUBS, Rank.KING, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();



        // assert pay player
        Assert.assertEquals(Integer.valueOf(100010), pokerGame.getDealer().getPlayer().getWallet());
    }

    @Test
    public void testCompareWinnerByLastCard5(){ // Tied Straight
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.CLUBS, Rank.KING, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.ACE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(100000), pokerGame.getDealer().getPlayer().getWallet());
    }

    @Test
    public void testCompareWinnerByLastCard6(){ // Tied Straight
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));

        pokerGame.getDealer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.CLUBS, Rank.EIGHT, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(100010), pokerGame.getDealer().getPlayer().getWallet());
    }

    @Test
    public void testCompareWinnerByLastCard7(){ // Tied Straight
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.KING, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.CLUBS, Rank.TEN, Suit.CLUBS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.CLUBS, Rank.EIGHT, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.TEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.DIAMONDS, Rank.NINE, Suit.DIAMONDS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.sortHands();

        //action
        pokerGame.compareByLastCard();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(100110), pokerGame.getPlayer().getPlayer().getWallet());
    }

    @Test
    public void testPush(){
        pokerGame.setPot(10);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN, Suit.CLUBS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.JACK, Suit.HEARTS.getSuitImage()));
        hand.add(new Card(Suit.DIAMONDS, Rank.JACK, Suit.DIAMONDS.getSuitImage()));
        hand.add(new Card(Suit.HEARTS, Rank.ACE, Suit.HEARTS.getSuitImage()));

        pokerGame.getPlayer().setHand(hand);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.QUEEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.JACK, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);

        pokerGame.push();

        // assert pay player
        Assert.assertEquals(Integer.valueOf(100010), pokerGame.getPlayer().getPlayer().getWallet());
    }

    @Test
    public void testDealerQualifies(){
        pokerGame.setPot(10);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.QUEEN, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.TEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.getPlayer().setHand(hand1);
        pokerGame.printResults();

        // assert pay player
        Assert.assertTrue(pokerGame.dealerQualifies());
    }
    @Test
    public void testDealerQualifies2(){
        pokerGame.setPot(10);

        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(Suit.DIAMONDS, Rank.DEUCE, Suit.DIAMONDS.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.TEN, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.SPADES, Rank.JACK, Suit.SPADES.getSuitImage()));
        hand1.add(new Card(Suit.CLUBS, Rank.SEVEN, Suit.CLUBS.getSuitImage()));
        hand1.add(new Card(Suit.HEARTS, Rank.FOUR, Suit.HEARTS.getSuitImage()));

        pokerGame.getDealer().setHand(hand1);
        pokerGame.getPlayer().setHand(hand1);
        pokerGame.printResults();

        // assert pay player
        Assert.assertFalse(pokerGame.dealerQualifies());
    }

}

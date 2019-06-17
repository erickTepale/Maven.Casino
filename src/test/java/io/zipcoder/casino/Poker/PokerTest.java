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
        this.player = new BasePlayer();
        this.dealer = new BasePlayer();
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


}

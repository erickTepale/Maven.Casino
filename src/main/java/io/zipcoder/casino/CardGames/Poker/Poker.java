package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.*;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;

public class Poker extends CardGame implements GamblingGame {
    private PokerPlayer player;
    private PokerPlayer dealer;
    private Integer minBet;
    private Integer bet;
    private Integer pot;
    private Integer[] wagerRecords; //2 rounds of betting
    private Console console;

    public Poker(BasePlayer player, BasePlayer dealer, Console consoleIO){
        super();
        this.player = new PokerPlayer(player);
        this.dealer = new PokerPlayer(dealer);
        this.pot = 0;
        this.minBet = 50;
        console = consoleIO;//new Console(System.in, System.out);

        welcomeMessage();
        initGame();
    }

    private void initGame(){
        String action = "";
        //cycle through options
        do {
            action = console.getStringInput(printMenu());
            switch (action.toUpperCase()) {
                case "RULES":
                    printRules();
                    break;
                case "BONUS":
                    printBonus();
                    break;
                case "RANK":
                    printHandRanking();
                    break;
                case "PLAY":
                    console.println(placeWager());
                    if(pot > 0){
                        dealer.setHand(super.deal(5));
                        player.setHand(super.deal(5));
                        sortHands();
                        console.println("\n"+ Hand.showHand((ArrayList<Card>)player.hand));
                        console.println(player.currentHandValue());
                        player.addCard(super.draw());
                    }

                    break;
            }

        }while(!action.equals("quit"));
    }

    private String printMenu(){
        return "\nPlease Type In An Option: " +
                "\nPlay:              [Play]" +
                "\nSee Rules:         [Rules]" +
                "\nSee Bonuses:       [Bonus]" +
                "\nSee Hand Rankings: [Rank]";
    }

    private void printHandRanking(){
        console.println("\nHand Rankings:\n\n" +
                             "Royal Flush:       " +
                                Rank.ACE.getRankString() + Suit.SPADES.getSuitImage() +
                                Rank.KING.getRankString()+ Suit.SPADES.getSuitImage() +
                                Rank.QUEEN.getRankString()+Suit.SPADES.getSuitImage() +
                                Rank.JACK.getRankString()+ Suit.SPADES.getSuitImage() +
                                Rank.TEN.getRankValue() + Suit.SPADES.getSuitImage() +
                             "\nStright Flush:     " +
                                Rank.TEN.getRankValue() + Suit.HEARTS.getSuitImage() +
                                Rank.NINE.getRankValue()+ Suit.HEARTS.getSuitImage() +
                                Rank.EIGHT.getRankValue()+Suit.HEARTS.getSuitImage() +
                                Rank.SEVEN.getRankValue()+ Suit.HEARTS.getSuitImage() +
                                Rank.SIX.getRankValue() + Suit.HEARTS.getSuitImage() +
                             "\nFull House:        " +
                                Rank.NINE.getRankValue() + Suit.DIAMONDS.getSuitImage() +
                                Rank.NINE.getRankValue()+ Suit.SPADES.getSuitImage() +
                                Rank.NINE.getRankValue()+Suit.HEARTS.getSuitImage() +
                                Rank.SIX.getRankValue()+ Suit.DIAMONDS.getSuitImage() +
                                Rank.SIX.getRankValue() + Suit.CLUBS.getSuitImage() +
                             "\nFlush:             " +
                                Rank.ACE.getRankString() + Suit.CLUBS.getSuitImage() +
                                Rank.JACK.getRankString()+ Suit.CLUBS.getSuitImage() +
                                Rank.DEUCE.getRankValue()+Suit.CLUBS.getSuitImage() +
                                Rank.SEVEN.getRankValue()+Suit.CLUBS.getSuitImage() +
                                Rank.FOUR.getRankValue() + Suit.CLUBS.getSuitImage() +
                             "\nStreight:          " +
                                Rank.TEN.getRankValue() + Suit.DIAMONDS.getSuitImage() +
                                Rank.NINE.getRankValue()+ Suit.CLUBS.getSuitImage() +
                                Rank.EIGHT.getRankValue()+Suit.SPADES.getSuitImage() +
                                Rank.SEVEN.getRankValue()+ Suit.HEARTS.getSuitImage() +
                                Rank.SIX.getRankValue() + Suit.HEARTS.getSuitImage() +
                             "\n3 Of A Kind:       " +
                                Rank.TEN.getRankValue() + Suit.DIAMONDS.getSuitImage() +
                                Rank.TEN.getRankValue()+ Suit.CLUBS.getSuitImage() +
                                Rank.TEN.getRankValue()+Suit.SPADES.getSuitImage() +
                                Rank.SEVEN.getRankValue()+ Suit.HEARTS.getSuitImage() +
                                Rank.SIX.getRankValue() + Suit.HEARTS.getSuitImage() +
                             "\n2 Pair:            " +
                                Rank.TEN.getRankValue() + Suit.DIAMONDS.getSuitImage() +
                                Rank.TEN.getRankValue()+ Suit.CLUBS.getSuitImage() +
                                Rank.EIGHT.getRankValue()+Suit.SPADES.getSuitImage() +
                                Rank.EIGHT.getRankValue()+ Suit.HEARTS.getSuitImage() +
                                Rank.SIX.getRankValue() + Suit.HEARTS.getSuitImage() );

    }

    private void printBonus(){
        console.println("\nPayout Bonuses:\nBeating the Dealer ->   2:1\n" +
                             "\t2 Pair:            3:1\n" +
                             "\t3 Of A King:       6:1\n" +
                             "\tStright:           9:1\n" +
                             "\tFlush:             13:1\n" +
                             "\tFull House:        19:1\n" +
                             "\tStreight Flush:    30:1\n" +
                             "\tRoyal Flush:       90:1");
    }

    private void printRules(){
        console.println("\nRules:" +
                "\nSingle Draw Poker is a variation of Poker,\n" +
                "You place your initial wager to recieve a hand and you double down\n" +
                "to either stay pat, or redraw selected cards to make a better hand.\n" +
                "Not doubling down is a folding action and you lose initial bet." +
                "\nDealer Must Have Queen High to Play! ");
    }

    private void sortHands(){
        Hand.sortHandByNumber((ArrayList<Card>)player.hand);
        Hand.sortHandByNumber((ArrayList<Card>)dealer.hand);
    }

    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    //INTERFACE GAMBLING GAME METHODS
    @Override
    public void welcomeMessage() {
        console.println("Welcome to Blits and Chips Poker Room");
        console.println("Here At Blits and Chips we play Single Draw Poker ");

    }

    //in poker.java
    public String placeWager() {
        Integer bet = 0;
        while(bet < minBet){
            bet = console.getIntegerInput("\nPlease input a wager(Min Bet: $" + minBet + ")");
            if(bet < minBet) console.println("Sorry, Minimum Bet is $" + minBet);
        }
        this.pot += bet;
        this.bet = bet;
        return player.placeWager(bet);
    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }

    // GETTERS
    public PokerPlayer getPlayer() {
        return player;
    }

    public PokerPlayer getDealer() {
        return dealer;
    }

    public Integer getMinBet() {
        return minBet;
    }

    public Integer getPot() {
        return pot;
    }

    public Integer[] getWagerRecords() {
        return wagerRecords;
    }
}
package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.CardGames.UtilitiesCards.Suit;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.GamblingGame;

import java.util.ArrayList;

public class PokerUserManager implements GamblingGame {
    private Console console;
    private Poker pokerGame;

    public PokerUserManager(BasePlayer base, BasePlayer dealer, Console console) {
        this.console = console;
        this.pokerGame = new Poker(base, dealer, console);

        welcomeMessage();
        initManager();
    }

    public void initManager(){
        String action = "";
        do{
            pokerGame.setPot(0);
            pokerGame.setFold(false);
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
                    placeWager();
                    pokerGame.deal();
                    printPlayerStats();
                    displayPlayerAction();
                    pokerGame.initGame(action);
                    break;

            }


            }while(!action.equals("quit"));
    }

    private void printPlayerStats(){
        /// BET PLACED ! ///
        pokerGame.sortHands();

        //dealers hand
//        console.println("\nDealer Hand: \n" + Hand.showHand((ArrayList<Card>)pokerGame.getDealer().hand));
//        console.println("Dealers Hand Value: " + pokerGame.getDealer().currentHandValue()[0]);

        //players hand
        console.println("\nYour Hand: \n" + Hand.showHand((ArrayList<Card>)pokerGame.getPlayer().hand));
        console.println("Hand Value: " + pokerGame.getPlayer().currentHandValue()[0]);


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
                "\t3 Of A Kind:       6:1\n" +
                "\tStright:           9:1\n" +
                "\tFlush:             13:1\n" +
                "\tFull House:        20:1\n" +
                "\tFour of A Kind:    90:1\n" +
                "\tStreight Flush:    300:1\n" +
                "\tRoyal Flush:       1000:1");
    }

    private void printRules(){
        console.println("\nRules:" +
                "\nSingle Draw Poker is a variation of Poker,\n" +
                "You place your initial wager to recieve a hand and you double down\n" +
                "to either stay pat, or redraw selected cards to make a better hand.\n" +
                "Not doubling down is a folding action and you lose initial bet." +
                "\nDealer Must Have Queen High to Play! ");
    }

    private void displayPlayerAction(){
        Integer a = -1;
        do {
            a = console.getIntegerInput("\nYou can either: \n" +
                    "Draw      [1]\n" +
                    "Stand Pat [2]\n" +
                    "Fold      [3]");

        }while(a < 0 || a > 3);
        switch (a){
            case 1:
                displayDrawMenu();
                break;
            case 2:
                //printResults();
                break;
            case 3:
                pokerGame.setFold(true);
                break;
        }

    }

    private void displayDrawMenu(){
        String input = "";
        Boolean inputParsed = false;
        clearConsole();
        console.println("Current Hand: " + pokerGame.getPlayer().currentHandValue()[0]);
        console.println(Hand.showHand((ArrayList<Card>) pokerGame.getPlayer().getHand()));
        console.println(" [1]  [2]  [3]  [4]  [5]");

        do {
            if(!input.equals(""))
                console.println("Please input valid numbers.\n");
            input = console.getStringInput("\nSelect the hands you wish to replace. " +
                    "\nExample: 1 4 5");
            inputParsed = pokerGame.parseDiscardInput(input);
        } while (inputParsed);
    }


    private void clearConsole(){
        console.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }



    @Override
    public void welcomeMessage() {
        console.println("Welcome to Blits and Chips Poker Room");
        console.println("Here At Blits and Chips we play Single Draw Poker ");
    }

    @Override
    public String placeWager() {
        Integer bet = 0;
        while(bet < pokerGame.getMinBet()){
            bet = console.getIntegerInput("\nPlease input a wager(Min Bet: $" + pokerGame.getMinBet() + ")");
            if(bet < pokerGame.getMinBet()) console.println("Sorry, Minimum Bet is $" + pokerGame.getMinBet());
        }

        pokerGame.placeWager(bet);
        return null;
    }

    @Override
    public void increaseMinBet() {

    }

    @Override
    public void decreaseMinBet() {

    }
}

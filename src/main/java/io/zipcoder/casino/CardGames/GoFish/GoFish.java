package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class GoFish extends CardGame {
    public GoFishPlayer player;
    public GoFishPlayer cpuPlayer;
    private EnumMap<Rank, Integer> playerHandMap;
    private Console console;
    //private EnumMap<Rank, Integer> cpuHandMap;

    public GoFish(BasePlayer player, BasePlayer cpuPlayer, Console consoleIO) {
        super();
        this.player = new GoFishPlayer(player);
        this.cpuPlayer = new GoFishPlayer((cpuPlayer));
        console = consoleIO;
        startGame();
    }

    public GoFish(BasePlayer player, BasePlayer cpuPlayer) {
        super();
        this.player = new GoFishPlayer(player);
        this.cpuPlayer = new GoFishPlayer((cpuPlayer));
    }


    public void setHand(GoFishPlayer player){
        player.hand = deal(7);
    }



    public void startGame(){
        String action;
        //cycle through options
        do {
            action = console.getStringInput(printMenu());
            switch (action.toUpperCase()) {
                case "RULES":
                    printRules();
                    break;
                case "PLAY":
                    setHand(player);
                    setHand(cpuPlayer);

                    sortHands();

                    console.println(Hand.showHand(player.hand));
                    break;
            }

        }while(!action.equals("quit"));
    }




    public void sortHands(){
        Hand.sortHandByNumber(player.hand);
        Hand.sortHandByNumber(cpuPlayer.hand);
    }





//    public void doTurn(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer, Integer cardValue){
//
//        ArrayList<Card> cardsToExchange = new ArrayList<>();
//        if (otherPlayer.hand.contains(cardValue)){
//            for (Card eachCard : otherPlayer.hand.getHand()){
//                otherPlayer.hand.
//            }
//        }
//    }











    public void cpuTurn(){


    }


    public void checkForBooks(GoFishPlayer player){
        playerHandMap = Hand.getHandMap(player.hand);

        for (Map.Entry<Rank, Integer> mapEntry : playerHandMap.entrySet()) {
            if (mapEntry.getValue() == 4) {
                Rank remove = mapEntry.getKey();
                player.hand.removeIf(thisCard -> thisCard.getFaceValue().equals(remove));
                player.setNumberOfBooks(player.getNumberOfBooks() + 1);
            }
        }
    }


    public boolean checkWin(){
        return (player.hand.size() == 0 || cpuPlayer.hand.size() == 0 || getDeckSize() == 0);
    }



    public void printRules(){
        console.println("\nA 'book' is a pair of four cards, based only on value (suit can be disregarded)." +
                "\nOn your turn, you may choose a card and ask the opponent if they have any of that card." +
                "\nIf they do, they must give you all of their cards of that type." +
                "\nIf they don't have any, then you 'go fish'! (Draw a card from the deck)." +
                "\nThe game is played until there are no cards remaining in the deck, or a player runs out of cards." +
                "\nThe player with the most books at the end of the game wins!");
    }


    public String printMenu(){
        return "\nPlease Type In An Option: " +
                "\nPlay:              [Play]" +
                "\nSee Rules:         [Rules]" +
                "\nReturn to Lobby:   [Quit]";
    }










    @Override
    public void switchTurns() {
        super.switchTurns();
    }
}
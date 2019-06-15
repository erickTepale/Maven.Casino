package io.zipcoder.casino.CardGames.GoFish;

import com.sun.javafx.binding.StringFormatter;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.utilities.Console;

import java.util.*;

public class GoFish extends CardGame {
    public GoFishPlayer player;
    public GoFishPlayer cpuPlayer;
    private EnumMap<Rank, Integer> playerHandMap;
    private Console console;
    String action;
    String cpuLastChoice;


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
        do {
            action = console.getStringInput(printMenu());
            switch (action.toUpperCase()) {
                case "RULES":
                    printRules();
                    break;
                case "PLAY":
                    console.println("\n\n");
                    setHand(player);
                    setHand(cpuPlayer);
                    playGame();
                    break;
            }
        }while(!action.equals("quit"));
    }




    public void playGame(){
        while (player.getNumberOfBooks() + cpuPlayer.getNumberOfBooks() < 13){
            checkForBooks(player);
            checkForBooks(cpuPlayer);
            sortHands();

            if (checkWin()) break;


            checkHand(player);
            playerTurn();
            doTurn(player, cpuPlayer, action);
            checkForBooks(player);
            if (checkWin()) break;

            checkHand(cpuPlayer);
            if (checkWin()) break;
            String cpuCardChoice = cpuTurn();
            doTurn(cpuPlayer, player, cpuCardChoice);
            if (checkWin()) break;
            checkForBooks(cpuPlayer);
        }
        console.println("Game over!");
    }


    public void sortHands(){
        Hand.sortHandByNumber(player.hand);
        Hand.sortHandByNumber(cpuPlayer.hand);
    }



    public Rank playerTurn() {
        printHand(player);
        console.println("Opponent's hand:");
        Rank thisCard = Rank.ACE;
        boolean isLooping = true;
        while (isLooping) {
            try {
                action = console.getStringInput("\nIt's your turn. What card would you like to ask your opponent for?");
                action = action.toUpperCase();
                thisCard = Enum.valueOf(Rank.class, action);
                isLooping = false;
            } catch (IllegalArgumentException e) {
                console.println("Invalid input, please try again.\n");
            }
        }
        return thisCard;
    }

    public String cpuTurn(){
        console.println("\nIt is your opponent's turn.");
        playerHandMap = Hand.getHandMap(cpuPlayer.hand);
        List<Rank> keysAsArray = new ArrayList<>(playerHandMap.keySet());

        Random r = new Random();
        Integer most = 0;
        if (cpuPlayer.hand.size() == 1){
            return keysAsArray.get(0).toString();
        }


        String cardChoice = keysAsArray.get(r.nextInt(keysAsArray.size())).toString();

        for (Map.Entry<Rank, Integer> mapEntry : playerHandMap.entrySet()) {
            if (mapEntry.getValue() >= most){
                most = mapEntry.getValue();
                cardChoice = mapEntry.getKey().toString();
                if (cardChoice.equals(cpuLastChoice)){
                    cardChoice = keysAsArray.get(r.nextInt(keysAsArray.size())).toString();
                }
            }
        }
        cpuLastChoice = cardChoice;
        console.println("Your opponent asks if you have any " + cardChoice.toLowerCase() + "s...");
        playerHandMap = Hand.getHandMap(player.hand);
        if (playerHandMap.containsKey(Enum.valueOf(Rank.class, cardChoice))){
            console.println("You begrudgingly hand over your card(s).");
        } else {
            console.println("But you don't have any!");
        }
        //doTurn(cpuPlayer, player, cardChoice);
        return cardChoice;
    }



    public void doTurn(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer, String cardValue){
        Rank thisCard = Enum.valueOf(Rank.class, cardValue);
        ArrayList<Card> cardsToExchange = new ArrayList<>();
        playerHandMap = Hand.getHandMap(otherPlayer.hand);

        if (playerHandMap.containsKey(thisCard)) {
            for (Iterator<Card> iterator = otherPlayer.hand.iterator(); iterator.hasNext(); ) {
                Card nextCard = iterator.next();
                if (nextCard.getFaceValue().getRankValue() == thisCard.getRankValue()) {
                    cardsToExchange.add(nextCard);
                    iterator.remove();
                }
            }
            currentPlayer.hand.addAll(cardsToExchange);
        } else {
            goFish(currentPlayer);
        }
    }


    public void goFish(GoFishPlayer currentPlayer) {
        console.println("\n~~~~~~~~~ GO FISH! ~~~~~~~~~\n");
        if (super.getDeckSize() == 0) {
            console.println("The deck is empty!");
        } else {
            Card fishedCard = super.deckGetter().draw();
            currentPlayer.hand.add(fishedCard);
        }
    }


    public void checkForBooks(GoFishPlayer player){
        playerHandMap = Hand.getHandMap(player.hand);

        for (Map.Entry<Rank, Integer> mapEntry : playerHandMap.entrySet()) {
            if (mapEntry.getValue() == 4) {
                Rank remove = mapEntry.getKey();
                player.hand.removeIf(thisCard -> thisCard.getFaceValue().equals(remove));
                player.setNumberOfBooks(player.getNumberOfBooks() + 1);
                console.println("\n");
                console.println("You have four " + mapEntry.getKey().toString().toLowerCase() + "s!");
                console.println("Your books: " + player.getNumberOfBooks());
                console.println("\n");
            }
        }
    }

    public void checkHand(GoFishPlayer player){
        if (player.hand.size() == 0){
            console.println("\nHand is empty!");
            goFish(player);
        }
    }






    public void printHand(GoFishPlayer player){
        Integer length = Hand.showHand(player.hand).length();
        String bars = String.format("%" + length + "s", "").replace(' ', '=');
        String yourHand = String.format("%" + (length/2 + 5) + "s", "Your Hand:");
        console.println(yourHand + "\n" + bars);
        console.println(Hand.showHand(player.hand));
        console.println(bars);

        StringBuilder bookBuilder = new StringBuilder();
        bookBuilder.append("You have " + player.getNumberOfBooks() + " book");
        if (player.getNumberOfBooks() == 1){
            bookBuilder.append(".");
        } else {
            bookBuilder.append("s.");
        }
        console.println(bookBuilder.toString());

        bookBuilder = new StringBuilder();
        bookBuilder.append("Your opponent has " + cpuPlayer.getNumberOfBooks() + " book");
        if (cpuPlayer.getNumberOfBooks() == 1){
            bookBuilder.append(".");
        } else {
            bookBuilder.append("s.");
        }
        console.println(bookBuilder.toString());
        console.println("Cards in deck: " + super.getDeckSize());
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

    public boolean checkWin(){
        return (!(player.getNumberOfBooks() + cpuPlayer.getNumberOfBooks() < 13));
    }


    @Override
    public void switchTurns() {
        super.switchTurns();
    }
}
package io.zipcoder.casino.utilities;

import io.zipcoder.casino.CardGames.Blackjack.Blackjack;
import io.zipcoder.casino.CardGames.GoFish.GoFish;
import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.DiceGames.Craps.Craps;
import io.zipcoder.casino.DiceGames.LastChance.LastChance;
import io.zipcoder.casino.Roulette.Roulette;
//import io.zipcoder.casino.Roulette.Roulette;

public class Lobby {
    private Console console;


    public Lobby() {
    }

    public Lobby(Console console, BasePlayer base, BasePlayer dealer) {
        this.console = console;
        boolean gameRunning = true;
        while (gameRunning) {
            console.println(base.printChar(console));
            console.println("1.) BlackJack\n2.) Poker\n3.) GoFish\n4.) Roulette\n5.) Craps\n6.) Last Chance\n7.) Bar\n8.) Exit\n");
            String game = console.getStringInput("Where would you like to go?");

            switch (game.toUpperCase()) {
                case "BLACKJACK":
                    Blackjack bj = new Blackjack(base, dealer, console);
                    break;
                case "POKER":
                    Poker poker = new Poker(base, dealer, console);
                    break;
                case "GOFISH":
                    GoFish gofish = new GoFish(base, dealer, console);
                    break;
                case "ROULETTE":
                    Roulette roulette = new Roulette(base,dealer);
                    break;
                case "CRAPS":
                    Craps craps = new Craps(base, dealer);
                    break;
                case "LAST CHANCE":
                    //LastChance lc = new LastChance(base,dealer);
                    break;
                case "BAR":
                    Bar bar = new Bar(base);
                    break;
                case "EXIT":
                    console.println("Thanks for stoppin' by!");
                    gameRunning = false;
                    break;


            }

        }
    }

//    public void printMenu() {
//        console.println("1.) BlackJack\n2.) Poker\n3.) GoFish\n4.) Roulette\n5.) Craps\n6.) Last Chance\n7.) Exit");
//        String game = console.getStringInput("Please choose a game below");
//    }


    //make base PLayer
    //create a menu class to display
    //initiate games based on option
}

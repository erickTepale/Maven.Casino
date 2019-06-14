package io.zipcoder.casino.utilities;

import io.zipcoder.casino.CardGames.Blackjack.Blackjack;
import io.zipcoder.casino.CardGames.GoFish.GoFish;
import io.zipcoder.casino.CardGames.Poker.Poker;
import io.zipcoder.casino.DiceGames.Craps.Craps;
import io.zipcoder.casino.DiceGames.LastChance.LastChance;
//import io.zipcoder.casino.Roulette.Roulette;

public class Lobby {
    private Console console;


    public Lobby() {


    }

    public Lobby(Console console, BasePlayer base, BasePlayer dealer) {
    this.console = console;
        //System.out.println("Welcome " + base.getName() + " to Blitz & Chips the most exclusive Casino in the World");
        boolean gameRunning = true;
        while (gameRunning) {
            String game = console.getStringInput("Please choose a game below");

            switch (game) {
                case "BlackJack":
                    Blackjack bj = new Blackjack(base, dealer);
                    break;
                case "Poker":
                    Poker poker = new Poker(base, dealer, console);
                    break;
                case "GoFish":
                    //GoFish gofish = new GoFish(base,dealer);
                    break;
                case "Roulette":
                    //Roulette roulette = new Roulette(base,dealer);
                    break;
                case "Craps":
                    Craps craps = new Craps(base, dealer);
                    break;
                case "Last Chance":
                    //LastChance lc = new LastChance(base,dealer);
                    break;
                case "Exit":
                    gameRunning = false;
                    break;


            }

        }


        //make base PLayer
        //create a menu class to display
        //initiate games based on option
    }
}

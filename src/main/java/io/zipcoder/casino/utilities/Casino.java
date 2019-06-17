package io.zipcoder.casino.utilities;


public class Casino {
    public static void main(String[] args) {

        Console console = new Console(System.in,System.out);
        console.println("Welcome to Blitz & Chips, the finest text based Casino in all the universe!");
        String name = console.getStringInput("\n...Haven't seen ya here before, what do they call ya?");
        BasePlayer blank = new BasePlayer(name);
        BasePlayer dealer = new BasePlayer("Dealer");
        console.println("Nice to meet ya, " + blank.getName() + "! Please enjoy yourself.\n");
        Lobby lobby = new Lobby(console, blank, dealer);
        // write your tests before you start fucking with this
    }
}

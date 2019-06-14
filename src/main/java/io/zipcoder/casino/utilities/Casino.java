package io.zipcoder.casino.utilities;


public class Casino {
    public static void main(String[] args) {

        Console console = new Console(System.in,System.out);
        String name = console.getStringInput("Please enter your name:");
        BasePlayer blank = new BasePlayer(name);
        BasePlayer dealer = new BasePlayer("Dealer");
        Lobby lobby = new Lobby(console, blank, dealer);
        // write your tests before you start fucking with this
    }
}

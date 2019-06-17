package io.zipcoder.casino.utilities;


import io.zipcoder.casino.DiceGames.UtilitiesDice.Dice;

public class Bar {
    private BasePlayer base;
    private Console console;
    String choice;


    public Bar(BasePlayer base) {
        this.base = base;
        this.console = new Console(System.in, System.out);
        intro();
    }

    public void intro() {
        console.println("\n\n\nYou meander into the smoke-filled Blitz & Chips bar...");
        console.println("You see a bartender behind the bar, an old man slumped at the bar, and a shady character smoking a cigarette in the corner.");
        startBar();
    }

    public void startBar() {

        boolean gameRunning = true;
        while (gameRunning) {
            base.printChar(console);
            console.println("=====================\n1.) Bartender\n2.) Old man\n3.) Shady character\n4.) Exit\n=====================");
            String choice = console.getStringInput("To whom would you like to speak?");

            switch (choice.toUpperCase()) {
                case "BARTENDER":
                    bartender();
                    break;
                case "OLD MAN":
                    oldMan();
                    break;
                case "SHADY CHARACTER":
                    shadyCharacter();
                    break;
                case "EXIT":
                    gameRunning = false;
                    break;
            }
        }
    }

    public void bartender() {
        choice = console.getStringInput("\nYou approach the bartender.\n\n'Would you like to buy a drink? We only serve martinis here. $20 a pop.'");
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")){
            console.println("You purchase a drink for the egregious price of $20.");
            base.removeFromWallet(20);
            console.println("Intoxication level increased!\n");
        }

    }

    public void oldMan() {
        if (base.getOwner() == false){
            console.println("\nYou approach the old man.\n'Howdy, I'm the owner of Blitz & Chips, have been for 40 years. But I'm gettin' too old for this gig...'");
            choice = console.getStringInput("\n'Say, you look like ya got a good head on your shoulders. Wanna take this place off my hands? I'll sell her to ya for $500,000.'");
            if (choice.equalsIgnoreCase("yes")){
                if (base.getWallet() >= 500000){
                    base.removeFromWallet(500000);
                    base.setOwner(true);
                    console.println("'Take good care of her!'\nThe old man hands over the deed to Blitz & Chips. You now own the casino!");
                } else {
                    console.println("'You don't have enough money! Get lost...'\n");
                }
            } else {
                console.println("Yeah, I don't blame ya, it's a lotta responsibility...\n");
            }
        } else {
            console.println("\nYou approach the old man.\n'Thanks for buying this joint off me... Take of her now, ya hear?'");
        }
    }

    public void shadyCharacter() {
        console.println("\nYou approach the shady character.");
        choice = console.getStringInput("\n'Hey there, you look like something of a risk taker... Care to play a round of russian roulette?'");
        if (choice.equalsIgnoreCase("yes")){
            choice = console.getStringInput("'You sure? You might lose it all...'");
            if (choice.equalsIgnoreCase("yes")) {
                russianRoulette();
            }
        } else {
            console.println("'Suit yourself...'\n");
        }
    }


    public void russianRoulette(){
        console.println("\nThe shady character leads you into a dimly lit back room.\n\n'Alright, kid, here's how this works." +
                "You're gonna bet all the money you got, 'cause why wouldn't ya? You win, you double your money... You lose, well...'" +
                "\nHe loads the revolver, spins it, and holds it up to your temple.");
        console.getStringInput("\n'Any last words?'");
        Integer diceRoll = (int) (Math.random() * 6 + 1);
        if (diceRoll == 1){
            console.println("\nYour life flashes before your eyes...\n\nGame over!");
            System.exit(0);
        } else {
            console.println("\n... you won! (phew...)\n");
            base.addToWallet(base.getWallet());
        }


    }


}

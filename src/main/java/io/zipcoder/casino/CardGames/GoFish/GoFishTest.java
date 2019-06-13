package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.utilities.BasePlayer;

public class GoFishTest {
    public static void main(String[] args) {

        BasePlayer player = new BasePlayer();
        BasePlayer cpuPlayer = new BasePlayer();

        GoFish thisGame = new GoFish(player, cpuPlayer);

        System.out.println(thisGame.getDeckSize());

        thisGame.player.setHand();
        thisGame.setPlayerHand(thisGame.cpuPlayer);

        System.out.println(thisGame.getDeckSize());

//        System.out.println(player.getHand().toString());
//        System.out.println(cpuPlayer.getHand().toString());
//        player.getHand().showHand();
//        cpuPlayer.getHand().showHand();



    }
}

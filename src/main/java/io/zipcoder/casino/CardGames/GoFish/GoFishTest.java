package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.utilities.BasePlayer;

public class GoFishTest {
    public static void main(String[] args) {


        BasePlayer basePlayer = new BasePlayer();
        BasePlayer baseCpuPlayer = new BasePlayer();

        GoFishPlayer player = new GoFishPlayer(basePlayer);
        GoFishPlayer cpuPlayer = new GoFishPlayer(baseCpuPlayer);


        GoFish thisGame = new GoFish(player, cpuPlayer);

        System.out.println(thisGame.getDeckSize());

        thisGame.setHand(player);
        thisGame.setHand(cpuPlayer);
        System.out.println(thisGame.getDeckSize());

        player.hand.sortHandByNumber();
        cpuPlayer.hand.sortHandByNumber();

        System.out.println(player.hand.showHand());
        System.out.println(cpuPlayer.hand.showHand());
    }
}

package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.utilities.BasePlayer;

public class GoFishTest {
    public static void main(String[] args) {


        BasePlayer basePlayer = new BasePlayer();
        BasePlayer baseCpuPlayer = new BasePlayer();

        GoFishPlayer player = new GoFishPlayer(basePlayer);
        GoFishPlayer cpuPlayer = new GoFishPlayer(baseCpuPlayer);


        //GoFish thisGame = new GoFish(player, cpuPlayer, );

        //thisGame.startGame();
    }
}

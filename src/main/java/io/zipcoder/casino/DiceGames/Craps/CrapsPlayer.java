package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.utilities.BasePlayer;

public class CrapsPlayer extends BasePlayer {
    private BasePlayer player;
    private BasePlayer dealer;



    public CrapsPlayer(String name) {
        super(name);
    }

    public Integer roll(int i) {
         return roll(2);
    }
}
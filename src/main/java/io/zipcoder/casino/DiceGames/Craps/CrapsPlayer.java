package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.utilities.BasePlayer;

public class CrapsPlayer extends BasePlayer {
    private BasePlayer player;
    private BasePlayer dealer;

    public CrapsPlayer (BasePlayer base, BasePlayer dealer){
        this.player = base;
        this.dealer = dealer;
    }

}
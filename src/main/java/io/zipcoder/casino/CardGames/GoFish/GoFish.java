package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;

public class GoFish extends CardGame {
    public GoFishPlayer player;
    public GoFishPlayer cpuPlayer;

    public GoFish(BasePlayer player, BasePlayer cpuPlayer) {
        super();
        this.player = new GoFishPlayer(player);
        this.cpuPlayer = new GoFishPlayer((cpuPlayer));
    }


    public void setHand(GoFishPlayer player){
        player.hand = new Hand(deal(7));
    }



    public void startGame(){

    }


    @Override
    public void switchTurns() {
        super.switchTurns();
    }
}
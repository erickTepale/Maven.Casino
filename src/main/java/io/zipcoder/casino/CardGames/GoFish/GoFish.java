package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Bin;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;
import io.zipcoder.casino.CardGames.UtilitiesCards.Deck;

public class GoFish extends CardGame implements Bin {
    public GoFishPlayer player;
    public GoFishPlayer cpuPlayer;

    public GoFish(BasePlayer player, BasePlayer cpuPlayer) {
        super();
        this.player = new GoFishPlayer(player);
        this.cpuPlayer = new GoFishPlayer((cpuPlayer));
    }


    public GoFish(BasePlayer player, BasePlayer cpuPlayer, Deck deck) {
        super(player, cpuPlayer, deck);
    }


    public void startGame(){

    }


//
//    public void setPlayerHand(GoFishPlayer goFishPlayer){
//        goFishPlayer.setHand(new Hand(this.deck.getHand(7)));
//        goFishPlayer.setHand(new Hand(this.deck.getHand(7)));
//    }




    public void add(Integer valueOfDice) {

    }

    @Override
    public void remove(Integer index) {

    }
//
//    public void remove(Integer index) {
//
//    }
//
//    public Boolean isWin() {
//        return null;
//    }

    @Override
    public void switchTurns() {
        super.switchTurns();
    }
}
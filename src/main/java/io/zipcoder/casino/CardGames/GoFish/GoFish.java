package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
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
        setHand(player);
        setHand(cpuPlayer);

        player.hand.sortHandByNumber();
        cpuPlayer.hand.sortHandByNumber();

        System.out.println(player.hand.showHand());

    }


    public void cpuTurn(){



    }


//    public void doTurn(GoFishPlayer currentPlayer, GoFishPlayer otherPlayer, Integer cardValue){
//
//        Hand cardsToExchange = new Hand();
//        if (otherPlayer.hand.getHand().contains(card)){
//            for (Card eachCard : otherPlayer.hand.getHand()){
//                otherPlayer.hand.
//            }
//        }
//    }




    @Override
    public void switchTurns() {
        super.switchTurns();
    }
}
package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.CardGame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class GoFish extends CardGame {
    public GoFishPlayer player;
    public GoFishPlayer cpuPlayer;
    private EnumMap<Rank, Integer> playerHandMap;
    //private EnumMap<Rank, Integer> cpuHandMap;

    public GoFish(BasePlayer player, BasePlayer cpuPlayer) {
        super();
        this.player = new GoFishPlayer(player);
        this.cpuPlayer = new GoFishPlayer((cpuPlayer));
    }


    public void setHand(GoFishPlayer player){
        player.hand = deal(7);
    }



    public void startGame(){
        setHand(player);
        setHand(cpuPlayer);

        Hand.sortHandByNumber(player.hand);
        Hand.sortHandByNumber(cpuPlayer.hand);

        System.out.println(Hand.showHand(player.hand));

    }


    public void cpuTurn(){


    }

    public void checkForBooks(GoFishPlayer player){
        playerHandMap = Hand.getHandMap(player.hand);

        for (Map.Entry<Rank, Integer> mapEntry : playerHandMap.entrySet()) {
            if (mapEntry.getValue() == 4) {
                for (Card card : player.hand) {
                    if (card.getFaceValue().equals(mapEntry.getKey())){
                        player.hand.remove(card);
                    }
                }
                player.setNumberOfBooks(player.getNumberOfBooks() + 1);
            }
        }
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
package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.List;

public class GoFishPlayer extends BasePlayer {
    private BasePlayer basePlayer;
    //private Hand hand;
    private List<Card> hand;
    private Integer numberOfBooks;
    private boolean win;

    public GoFishPlayer(){
        this.hand = new ArrayList<>();
        this.numberOfBooks = 0;
        this.win = false;
    }


    public GoFishPlayer(BasePlayer player) {
        this.basePlayer = player;
        this.hand = new ArrayList<>();
        this.numberOfBooks = 0;
        this.win = false;
    }

//    public void setHand(ArrayList<Card> hand){
//        this.hand = super.g;
//    }



//    public Hand getHand() {
//        return this.hand;
//    }
//
//    public void setHand(Hand hand) {
//        this.hand = hand;
//    }
//
//    public void setFirstHand(Hand hand) {
//        this.hand = hand;
//    }




    public void ask(){}
    public void fetch(){}

}
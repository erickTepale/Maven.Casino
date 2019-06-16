package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer extends BasePlayer {
    private BasePlayer player;

    public List<Card> hand;
    private Boolean stand;
    private Boolean bust;
    private Integer handValue;

    public void setHandValue(Integer handValue) {
        this.handValue = handValue;
    }

    public Integer getHandValue() {
        return this.handValue;
    }
    public void addCard(Card newCard){
        hand.add(newCard);
    }

    public BlackjackPlayer(BasePlayer player){
        this.player = player;

    }
    public BlackjackPlayer(String name) {
        super(name);
    }

    public Card hit(){

        return null;

    }
    public String showCard(){


        return null;
    }




    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }
    public void doubleDown(){


    }

    public BasePlayer getPlayer(){
        return player;
    }


    public void split(){

    }
}
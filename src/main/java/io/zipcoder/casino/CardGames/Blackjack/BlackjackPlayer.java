package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer extends BasePlayer {
    private BasePlayer player;
    private List<Card> hand;
    private Boolean stand;
    private Boolean bust;

    public BlackjackPlayer(BasePlayer player){
        this.player = player;
    }
    public BlackjackPlayer(String name) {
        super(name);
    }

    public Card hit(){

        return null;

    }


    public void addCard(Card a){
        hand.add(a);
    }

    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }
    public void doubleDown(){


    }

    public void split(){

    }
}
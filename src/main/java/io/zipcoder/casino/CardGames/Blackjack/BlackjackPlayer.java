package io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.List;

public class BlackjackPlayer extends BasePlayer {
    private List<Card> hand;
    private Boolean stand;
    private Boolean bust;

    public BlackjackPlayer(String name) {
        super(name);
    }

    public Card hit(){

        return null;

    }
    public void doubleDown(){


    }

    public void split(){

    }
}
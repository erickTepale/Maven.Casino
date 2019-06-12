package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.List;

public class PokerPlayer extends BasePlayer {
    private BasePlayer player;
    private Boolean stand;
    List<Card> hand;

    public PokerPlayer(String name, BasePlayer player) {
        super(name);
        this.player = player;
    }

    public void raise(){

    }
    public void call(){

    }
    public void check(){

    }
}

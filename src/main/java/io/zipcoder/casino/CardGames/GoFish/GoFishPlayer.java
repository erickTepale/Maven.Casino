package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.List;

public class GoFishPlayer extends BasePlayer {
    private BasePlayer basePlayer;
    private List<Card> hand;

    public GoFishPlayer(String name, BasePlayer player) {
        super(name);
        this.basePlayer = basePlayer;
    }



    public void ask(){}
    public void fetch(){}

}
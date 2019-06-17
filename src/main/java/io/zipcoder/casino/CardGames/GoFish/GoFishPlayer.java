package io.zipcoder.casino.CardGames.GoFish;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;

public class GoFishPlayer extends BasePlayer {
    private BasePlayer basePlayer;
    public ArrayList<Card> hand;
    private Integer numberOfBooks;


    public GoFishPlayer(){
        super();
        this.numberOfBooks = 0;
    }


    public GoFishPlayer(BasePlayer player) {
        super();
        this.basePlayer = player;
        this.numberOfBooks = 0;
    }




    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

}
package io.zipcoder.casino.CardGames.GoFish;

import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class GoFishPlayer extends BasePlayer {
    private BasePlayer basePlayer;
    public ArrayList<Card> hand;


    private Integer numberOfBooks;
    private boolean win;
    public String name;
    private EnumMap<Rank, Integer> handMap;

    public GoFishPlayer(){
        super();
        //this.name = "Go Fish Player";
        this.numberOfBooks = 0;
        this.win = false;
    }


    public GoFishPlayer(BasePlayer player) {
        super();
        this.basePlayer = player;
        this.numberOfBooks = 0;
        this.win = false;
    }




    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }




    @Override
    public String getName() {
        return super.getName();
    }


    public void ask(){}
    public void fetch(){}

}
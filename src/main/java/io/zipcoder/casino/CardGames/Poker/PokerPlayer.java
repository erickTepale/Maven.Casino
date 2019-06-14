package io.zipcoder.casino.CardGames.Poker;

// import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokerPlayer extends BasePlayer {
    private BasePlayer player;
    private Boolean stand;
    List<Card> hand;

    public PokerPlayer(BasePlayer player) {
        this.player = player;
        hand = new ArrayList<>();
    }

    public String currentHandValue(){
        Hand.sortHandByNumber((ArrayList<Card>) hand);
        return null;
    }

    public void raise(){

    }
    public void call(){

    }
    public void check(){

    }
    public Boolean checkRoyal (){

        return null;
    }

    public Boolean checkStraight(){
        return null;
    }

    public Boolean checkFlush(){
        return null;
    }

    public Boolean checkTwoPair(){
        return null;
    }

    public Boolean checkPair(){
        return null;
    }

    public Boolean QHigh(){
        return null;
    }

    //in pokerPlayer.java
    public String placeWager(int bet){
       return player.removeFromWallet(bet) ? "Bet Placed!" : "Insufficient Funds!";
    }


    public BasePlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasePlayer player) {
        this.player = player;
    }

    public Boolean getStand() {
        return stand;
    }

    public void setStand(Boolean stand) {
        this.stand = stand;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}

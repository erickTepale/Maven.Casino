package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.Hand;
import io.zipcoder.casino.CardGames.UtilitiesCards.Rank;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.CardGames.UtilitiesCards.Card;

import java.util.*;

public class PokerPlayer extends BasePlayer {
    private BasePlayer player;
    private Boolean stand;
    List<Card> hand;

    public PokerPlayer(BasePlayer player) {
        this.player = player;
        hand = new ArrayList<>();
    }

    public String currentHandValue(){
        if(checkRoyal())
            return "Royal Flush";
        else if(checkStraight())
            return "Straight Flush";
        else if(check4Kind())
            return "Four of a Kind";
        else if(checkBoat())
            return "Full House";
        else if(checkFlush())
            return "Flush";
        else if(checkStraight())
            return "Straight";
        else if(check3Kind())
            return "Three of a Kind";
        else if(checkTwoPair())
            return "Two Pair";
        else if(checkPair())
            return "Pair";
        else
            return "High Card";

    }

    public void reDraw(Integer[] toReDraw){
        Arrays.sort(toReDraw);
        for (int i = toReDraw.length - 1; i >= 0 ; i--) {
            hand.remove(toReDraw[i] - 1);
            //removing index arr[i] - 1 - i because size of array changes as you delete
            //so if size of array starts at 5 and you delete index 1.
            //size is now 4 and if you try to delete index 5 you get a null pointer!
        }
    }

    public String addCard(Card newCard){
        if(hand.size() <= 41) {
            hand.add(newCard);
            return "Card Added";
        }
        return "No More Cards";

    }

    public Boolean checkRoyal (){
        if(checkStraight() && checkFlush()){
            return hand.get(0).getFaceValue().getRankValue() == 1 && hand.get(4).getFaceValue().getRankValue() == 13;
        }
        return false;
    }

    public Boolean checkStraightFlush(){
        return checkStraight() && checkFlush();
    }

    public Boolean checkStraight(){
        Boolean straight = true;

        if(hand.get(0).getFaceValue().getRankValue() == 1 &&
                hand.get(1).getFaceValue().getRankValue() == 10 &&
                hand.get(2).getFaceValue().getRankValue() == 11 &&
                hand.get(3).getFaceValue().getRankValue() == 12 &&
                hand.get(4).getFaceValue().getRankValue() == 13){return true;}

        for (int i = 0; i < hand.size() - 1 ; i++) {
            if(hand.get(i).getFaceValue().getRankValue()+1 != hand.get(i+1).getFaceValue().getRankValue())
                straight = false;
        }

        return straight;
    }

    public Boolean checkFlush(){
        Boolean flush = true;
        String suit = hand.get(0).getSuite().getSuitText();
        for (int i = 0; i < hand.size() ; i++) {
            if(!hand.get(i).getSuite().getSuitText().equals(suit))
                flush = false;
        }
        return flush;
    }

    public Boolean check3Kind(){
        Integer counter = 0;
        Map<Rank, Integer> map = Hand.getHandMap((ArrayList<Card>) hand);
        for(Map.Entry<Rank, Integer> mapEntry : map.entrySet()){
            if(mapEntry.getValue() == 3)
                counter++;
        }
        return counter == 1;

    }

    public Boolean check4Kind(){
        Integer counter = 0;
        Map<Rank, Integer> map = Hand.getHandMap((ArrayList<Card>) hand);
        for(Map.Entry<Rank, Integer> mapEntry : map.entrySet()){
            if(mapEntry.getValue() == 4)
                counter++;
        }
        return counter == 1;
    }

    public Boolean checkBoat(){
        return check3Kind() && checkPair();
    }

    public Boolean checkTwoPair(){
        return (countPairs() == 2);
    }

    public Boolean checkPair(){
        return (countPairs() == 1);
    }

    private Integer countPairs() {
        Integer counter = 0;
        Map<Rank, Integer> map = Hand.getHandMap((ArrayList<Card>) hand);
        for(Map.Entry<Rank, Integer> mapEntry : map.entrySet()){
            if(mapEntry.getValue() == 2)
                counter++;
        }
        return counter;
    }

    public Boolean QHigh(){
        for (int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getFaceValue().getRankString().equals("Q") ||
                hand.get(i).getFaceValue().getRankString().equals("K") ||
                hand.get(i).getFaceValue().getRankString().equals("A"))
                return true;
        }
        return false;
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

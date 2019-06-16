package io.zipcoder.casino.CardGames.UtilitiesCards;

public enum Rank {
    ACE(1,"A",11), DEUCE(2, "Duece",2), THREE(3, "Three",3), FOUR(4, "Four",4), FIVE(5, "Five",5),
    SIX(6, "Six",6), SEVEN(7, "Seven",7), EIGHT(8, "Eight",8), NINE(9, "Nine",9), TEN(10, "Ten",10),
    JACK(11, "J",10), QUEEN(12, "Q",10), KING(13, "K",10);

    private Integer rankValue;
    private String rankString;
    private int blackJackValue;

    Rank(int rankValue, String rankString,int blackJackValue) {
        this.rankValue = rankValue;
        this.rankString = rankString;
        this.blackJackValue = blackJackValue;
    }

    public int getRankValue() {
        return rankValue;
    }
    public int getBlackJackValue(){
        return blackJackValue;
    }

    public void setRankValue() {
        this.rankValue = rankValue;
    }

    public String getRankString() {
        return rankString;
    }

    public void setRankString(String rankString) {
        this.rankString = rankString;
    }
}
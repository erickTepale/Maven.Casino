package io.zipcoder.casino.CardGames.UtilitiesCards;

public enum Rank {
    ACE(1,"A"), DEUCE(2, "Duece"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"),
    SIX(6, "Six"), SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"),
    JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K");

    private int rankValue;
    private String rankString;

    Rank(int rankValue, String rankString) {
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    public int getRankValue() {
        return rankValue;
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
package io.zipcoder.casino.CardGames.UtilitiesCards;

public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank faceValue;
    private Boolean isFaceUp;
    //can define as enum

    public Card(Suit suit, Rank faceValue) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public Suit getSuite() {
        return this.suit;
    }

    public void setSuite(Suit suit) {
        this.suit = suit;
    }

    public Rank getFaceValue() {
        return this.faceValue;
    }

    public void setFaceValue(Rank faceValue) {
        this.faceValue = faceValue;
    }


    public String printCard(){
        return this.faceValue.getRankString() + " of " + this.suit.getSuitText();
    }


    @Override
    public int compareTo(Card card) {
        return (this.getFaceValue().getRankValue() < card.getFaceValue().getRankValue() ? -1 :
                (this.getFaceValue().getRankValue() == card.getFaceValue().getRankValue() ? 0 : 1));
    }
}
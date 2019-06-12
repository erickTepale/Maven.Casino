package io.zipcoder.casino.CardGames.UtilitiesCards;

public class Card {
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
        String thisCard;
        if (this.faceValue.getRankValue() > 10 || this.faceValue.getRankValue() == 1){
            thisCard = this.faceValue.getRankString() + " of " + this.suit.getSuitText();
        } else {
            thisCard = this.faceValue.getRankValue() + " of " + this.suit.getSuitText();
        }
        return thisCard;
    }
}
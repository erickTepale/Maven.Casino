package io.zipcoder.casino.CardGames.UtilitiesCards;

public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank faceValue;
    private char imageValue;
    private Boolean isFaceUp;
    //can define as enum

    public Card(Suit suit, Rank faceValue, char imageValue) {
        this.faceValue = faceValue;
        this.suit = suit;
        this.imageValue = imageValue;
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

    public char getImageValue() {
        return imageValue;
    }

    public String printCard(){
        String thisCard;
        if (this.faceValue.getRankValue() > 10 || this.faceValue.getRankValue() == 1){
            thisCard = this.faceValue.getRankString() + this.imageValue;
        } else {
            thisCard = this.faceValue.getRankValue() + "" + this.imageValue;
        }
        return thisCard;
    }


    @Override
    public int compareTo(Card card) {
        return (this.getFaceValue().getRankValue() < card.getFaceValue().getRankValue() ? -1 :
                (this.getFaceValue().getRankValue() == card.getFaceValue().getRankValue() ? 0 : 1));
    }
}
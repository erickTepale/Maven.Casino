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

    public String printCard() {
//        return this.faceValue.getRankString() + "" + this.suit.getSuitImage();
//    }
        String thisCard = "";
        if (this.faceValue.getRankValue() > 10 || this.faceValue.getRankValue() == 1) {
            thisCard += this.faceValue.getRankString();
        } else {
            thisCard += this.faceValue.getRankValue();
        }
        return thisCard + "" + this.suit.getSuitImage();
    }


    @Override
    public int compareTo(Card card) {
//        final Integer numCompare = Integer.compare(this.getFaceValue().getRankValue(), card.getFaceValue().getRankValue());
//        final Integer suitCompare = compare(this.getSuite().getSuitText(), card.getSuite().getSuitText());


        int numCompare = Integer.compare(this.getFaceValue().getRankValue(), card.getFaceValue().getRankValue());
        int suitCompare = (this.suit.getSuitText().compareTo(card.suit.getSuitText()));
        if (numCompare != 0) {
            return numCompare;
        }
        return suitCompare;
    }


//        if (numCompare == 0) {
//            return suitCompare;
//        } else {
//            return numCompare;
//        }
}
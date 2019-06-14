package io.zipcoder.casino.CardGames.UtilitiesCards;

public enum Suit {
    HEARTS("Hearts", '\u2764'),
    SPADES("Spades", '\u2660'),
    DIAMONDS("Diamonds", '\u2666'),
    CLUBS("Clubs", '\u2663');

    private final String suitText;
    private final char suitImage;

    Suit(String suitText, char suitImage) {
        this.suitText = suitText;
        this.suitImage = suitImage;
    }

    public String getSuitText() {
        return suitText;
    }
    public char getSuitImage(){
        return suitImage;
    }
}
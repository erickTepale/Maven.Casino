public class Card {
    private String suit;
    private String rank;
    private Boolean isFaceUp;
    //can define as enum

    public Card(String suit, String rank, Boolean isFaceUp) {
        this.suit = suit;
        this.rank = rank;
        this.isFaceUp = isFaceUp;
    }
}
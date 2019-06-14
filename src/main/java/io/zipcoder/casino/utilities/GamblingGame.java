package io.zipcoder.casino.utilities;

public interface GamblingGame {

    public void welcomeMessage();
    public void placeWager(); //Set Boolean
    public void payBet();
    public void increaseMinBet();
    public void decreaseMinBet();

}
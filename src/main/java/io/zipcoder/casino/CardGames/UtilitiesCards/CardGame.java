package io.zipcoder.casino.CardGames.UtilitiesCards;

import io.zipcoder.casino.CardGames.UtilitiesCards.Card;
import io.zipcoder.casino.utilities.Game;

import java.util.ArrayList;
import java.util.Stack;

public abstract class CardGame extends Game {
    //does cardgame get deal and draw? or stay in deck
    private Stack<Card> deck;


    public ArrayList<Card> deal(Integer numOfCards){ return null; }
}
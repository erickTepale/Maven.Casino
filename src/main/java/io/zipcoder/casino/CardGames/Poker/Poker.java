package io.zipcoder.casino.CardGames.Poker;

import io.zipcoder.casino.CardGames.UtilitiesCards.*;
import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class Poker extends CardGame{
    private PokerPlayer player;
    private PokerPlayer dealer;
    private Integer minBet;
    private Integer bet;
    private Boolean fold;
    private Integer [] discard;
    private Integer pot;
    private Integer[] wagerRecords; //2 rounds of betting
    private Console console;

    public Poker(BasePlayer player, BasePlayer dealer, Console consoleIO){
        super();
        this.player = new PokerPlayer(player);
        this.dealer = new PokerPlayer(dealer);
        this.pot = 0;
        this.fold = false;
        this.minBet = 50;
        console = consoleIO;//new Console(System.in, System.out);
    }

    public void initGame(String action){
        switch (action.toUpperCase()){
            case "PLAY":
                if(!fold && (discard != null)){
                    player.reDraw(discard);
                    reAdd();
                    sortHands();
                }

                //dealers hand
                console.println("\nDealer Hand: \n" + Hand.showHand((ArrayList<Card>)dealer.hand));
                console.println("Dealers Hand Value: " + dealer.currentHandValue()[0]);

                //players hand
                console.println("\nYour Hand: \n" + Hand.showHand((ArrayList<Card>)player.hand));
                console.println("Hand Value: " + player.currentHandValue()[0]);

                //Print Results
                if(!fold)
                    printResults();
                else {
                    displayLost();
                    payDealer();
                }

                break;
        }
    }

    public void deal(){
        dealer.setHand(super.deal(5));
        player.setHand(super.deal(5));
    }

    public void sortHands(){
        Hand.sortHandByNumber((ArrayList<Card>)player.hand);
        Hand.sortHandByNumber((ArrayList<Card>)dealer.hand);
    }

    public void reAdd(){
        for (int i = 0; i <discard.length ; i++) {
            player.hand.add(super.draw());
        }

    }

    public Boolean parseDiscardInput(String input){
        String [] a = input.split(" ");
        discard  = new Integer[a.length];

        for (int i = 0; i <a.length ; i++) {
            if(!a[i].matches("-?\\d+(\\.\\d+)?"))
                return true;
            else {
                discard[i] = Integer.parseInt(a[i]);
            }
        }
        return false;
    }

    public void printResults(){
        if(dealerQualifies()){
            checkWinner();
        }else {
            push();
            console.println("Dealer Does not Qualify to play, Bets Pushed");
        }

    }

    public void checkWinner(){
        String [] playerResults = player.currentHandValue();
        String [] dealerResults = dealer.currentHandValue();

        if(Integer.parseInt(playerResults[1]) > Integer.parseInt(dealerResults[1])){
            payPlayer();
        }
        else if (Integer.parseInt(playerResults[1]) < Integer.parseInt(dealerResults[1])){
            payDealer();
        }
        else {
            tie();
        }
    }

    protected void tie(){
        switch (player.currentHandValue()[0]) {
            case "Royal Flush":
                push(1);
                break;
            case "Straight Flush":
                compareByLastCard();
                break;

            case "Four of a Kind":
                if(playerWinFourKind()){
                    payPlayer();
                }else{
                    payDealer();
                }
                break;
            case "Full House":
                if(playerWinFullHouse() == 1){
                    payPlayer();
                }else {
                    payDealer();
                }
                break;
            case "Flush":
                compareByLastCard();
                break;
            case "Straight":
                compareByLastCard();
                break;
            case "Three of a Kind":
                if(playerWinFullHouse() == 1){
                    payPlayer();
                }else if(playerWinFullHouse() == -1){
                    payDealer();
                }
                else{
                    if(playerWinsKicker() == 1)
                        payPlayer();
                    else if(playerWinsKicker() == -1)
                        payDealer();
                    else
                        push(1);
                }
                break;
            case "Two Pair":
                if(playerWins2Pair() == 1){
                    payPlayer();
                }else if(playerWins2Pair() == -1)
                    payDealer();
                else{
                    if(playerWinsKicker() == 1)
                        payPlayer();
                    else if (playerWinsKicker() == -1)
                        payDealer();
                    else
                        push(1);
                }
                break;
            case "One Pair":
                if(playerWinPair() == 1)
                    payPlayer();
                else if(playerWinPair() == -1)
                    payDealer();
                else {
                    if(playerWinsKicker() == 1)
                        payPlayer();
                    else if(playerWinsKicker() == -1)
                        payDealer();
                    else
                        push(1);
                }
                break;
            case "High Card":
                if(playerWinsHighCard() == 1)
                    payPlayer();
                else if(playerWinsHighCard() == -1)
                    payDealer();
                else
                    push(1);
                break;
            default:
                System.out.println("idk homie");

        }

    }

    public Integer playerWinsHighCard(){
        Integer playerSum = 0;
        Integer dealerSum = 0;

        for (int i = 0; i < player.getHand().size(); i++) {
            if(player.getHand().get(i).getFaceValue().getRankValue() == 1)
                playerSum += 14;
            if (dealer.getHand().get(i).getFaceValue().getRankValue() == 1)
                dealerSum += 14;

            playerSum += player.getHand().get(i).getFaceValue().getRankValue();
            dealerSum += dealer.getHand().get(i).getFaceValue().getRankValue();
        }
        if (playerSum > dealerSum)
            return 1;
        else if(playerSum < dealerSum)
            return -1;
        else
            return 0;
    }

    public Integer playerWins2Pair(){
        //prob works tho
        Integer playerValue = 0;
        Integer dealerValue = 0;
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());

        for(Map.Entry<Rank, Integer> mapEntry : handMap.entrySet()){
            if(mapEntry.getValue() == 2)
                if(playerValue <  mapEntry.getKey().getRankValue()) {
                    if (playerValue != 1)
                        playerValue = mapEntry.getKey().getRankValue();
                }
        }

        for(Map.Entry<Rank, Integer> mapEntry : handMapDealer.entrySet()){
            if(mapEntry.getValue() == 2)
                if(dealerValue < mapEntry.getKey().getRankValue()) {
                    if (dealerValue != 1)
                        dealerValue = mapEntry.getKey().getRankValue();
                }
        }

        if(playerValue == 1)
            playerValue = 14;
        if(dealerValue == 1)
            dealerValue = 14;

        if(playerValue > dealerValue)
            return 1;

        if(playerValue < dealerValue)
            return -1;


        return 0; // tie
    }

    public Integer playerWinsKicker(){
        //prob works tho
        Integer playerSum = 0;
        Integer dealerSum = 0;
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());

        playerSum = kickerSum(handMap);

        dealerSum = kickerSum(handMapDealer);

        if(playerSum > dealerSum)
            return 1;

        if(playerSum < dealerSum)
            return -1;


        return 0; // tie

    }

    public void displayLost(){
        setFold(true);
        console.println("\nFolded");
    }

    private Integer kickerSum(EnumMap<Rank, Integer> handMapDealer) {
        Integer sum = 0;
        for(Map.Entry<Rank, Integer> mapEntry : handMapDealer.entrySet()){
            if(mapEntry.getValue() == 1)
                if(mapEntry.getKey().getRankValue() == 1)
                    sum += 13;
                else
                    sum += mapEntry.getKey().getRankValue();
        }
        return sum;
    }

    public void compareByLastCard() {
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());
        int playerSum = kickerSum(handMap);
        int dealerSum = kickerSum(handMapDealer);

        if(playerSum == dealerSum){ //identical hands
            push(1);
        } else if(player.getHand().get(0).getFaceValue().getRankValue() == 1 && !(dealer.getHand().get(0).getFaceValue().getRankValue() == 1)){
            payPlayer();
        } else if(dealer.getHand().get(0).getFaceValue().getRankValue() == 1 && !(player.getHand().get(0).getFaceValue().getRankValue() == 1)){
            payDealer();
        } else if(player.getHand().get(4).getFaceValue().getRankValue() > dealer.getHand().get(4).getFaceValue().getRankValue()){
            payPlayer();
        }else if(player.getHand().get(4).getFaceValue().getRankValue() < dealer.getHand().get(4).getFaceValue().getRankValue()){
            payDealer();
        }
    }

    public Integer playerWinPair(){
        //prob works tho
        Integer playerValue = 0;
        Integer dealerValue = 0;
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());

        for(Map.Entry<Rank, Integer> mapEntry : handMap.entrySet()){
            if(mapEntry.getValue() == 2)
                playerValue = mapEntry.getKey().getRankValue();
        }

        for(Map.Entry<Rank, Integer> mapEntry : handMapDealer.entrySet()){
            if(mapEntry.getValue() == 2)
                dealerValue = mapEntry.getKey().getRankValue();
        }



        if(playerValue == 1)
            playerValue = 14;
        if(dealerValue == 1)
            dealerValue = 14;

        if(playerValue > dealerValue)
            return 1;

        if(playerValue < dealerValue)
            return -1;


        return 0; // tie
    }

    public Boolean playerWinFourKind(){
        //prob works tho
        Integer playerValue = 0;
        Integer dealerValue = 0;
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());

        for(Map.Entry<Rank, Integer> mapEntry : handMap.entrySet()){
            if(mapEntry.getValue() == 4)
                playerValue = mapEntry.getKey().getRankValue();
        }

        for(Map.Entry<Rank, Integer> mapEntry : handMapDealer.entrySet()){
            if(mapEntry.getValue() == 4)
                dealerValue = mapEntry.getKey().getRankValue();
        }

        if(playerValue == 1)
            return true;


        return playerValue > dealerValue;
    }

    public Integer playerWinFullHouse(){//also 3 of a kind
        Integer playerValue = 0;
        Integer dealerValue = 0;
        EnumMap<Rank, Integer> handMap = Hand.getHandMap((ArrayList<Card>)player.getHand());
        EnumMap<Rank, Integer> handMapDealer = Hand.getHandMap((ArrayList<Card>)dealer.getHand());

        for(Map.Entry<Rank, Integer> mapEntry : handMap.entrySet()){
            if(mapEntry.getValue() == 3)
                playerValue = mapEntry.getKey().getRankValue();
        }

        for(Map.Entry<Rank, Integer> mapEntry : handMapDealer.entrySet()){
            if(mapEntry.getValue() == 3)
                dealerValue = mapEntry.getKey().getRankValue();
        }

        if(playerValue == 1)
            return 1;

        if(playerValue > dealerValue)
            return 1;

        if(playerValue < dealerValue)
            return -1;


        return 0; // tie
    }

    protected void payDealer(){
        dealer.getPlayer().addToWallet(pot);
        console.println("Sorry You Lost: " + pot);
    }

    protected void payPlayer(){
        Integer totalPayout = 0;
        Integer bonus = Integer.parseInt(player.currentHandValue()[1]);
        if(bonus == 2)
            bonus = 1;

        totalPayout += pot * 2;
        if (bonus > 1)
            totalPayout += pot * bonus;
        player.getPlayer().addToWallet(totalPayout);
        dealer.getPlayer().removeFromWallet(totalPayout);
        console.println("\nCongratlations ! You Won: " + totalPayout);
    }

    public boolean dealerQualifies(){
        //Check if dealer Qualifies to play
        if(dealer.currentHandValue()[0].equals("High Card"))
            return dealer.QHigh();

        return true;
    }

    //return bet to player
    public void push(){
        player.getPlayer().addToWallet(pot);
        console.println("Dealer Does not have Q High");
    }

    protected void push(Integer one){
        player.getPlayer().addToWallet(pot);
        console.println("Dealer and Player have equivalent hand");
    }




    public Boolean isWin() {
        return null;
    }

    public void switchTurns() {

    }

    //INTERFACE GAMBLING GAME METHODS
    //in poker.java
    public String placeWager(Integer wager) {
        this.pot += wager;
        this.bet = wager;
        return player.placeWager(wager);
    }

    public void increaseMinBet() {

    }

    public void decreaseMinBet() {

    }

    // GETTERS
    public PokerPlayer getPlayer() {
        return player;
    }

    public PokerPlayer getDealer() {
        return dealer;
    }

    public Integer getMinBet() {
        return minBet;
    }

    public Integer getPot() {
        return pot;
    }

    public Integer[] getWagerRecords() {
        return wagerRecords;
    }

    public void setPlayer(PokerPlayer player) {
        this.player = player;
    }

    public void setDealer(PokerPlayer dealer) {
        this.dealer = dealer;
    }

    public void setMinBet(Integer minBet) {
        this.minBet = minBet;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public Boolean getFold() {
        return fold;
    }

    public void setFold(Boolean fold) {
        this.fold = fold;
    }

    public Integer[] getDiscard() {
        return discard;
    }

    public void setDiscard(Integer[] discard) {
        this.discard = discard;
    }

    public void setPot(Integer pot) {
        this.pot = pot;
    }

    public void setWagerRecords(Integer[] wagerRecords) {
        this.wagerRecords = wagerRecords;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}
package io.zipcoder.casino.utilities;

public  class BasePlayer {
    private Integer wallet;
    private String name;
    private boolean isOwner;

    public BasePlayer(){this.wallet = 100000;}

    public BasePlayer(String name) {
        this.name = name;
        this.wallet = 100000;
        this.isOwner = false;
    }

    public String getName() {
        return name;
    }

    public void addToWallet(Integer amount){
        wallet += amount;
    }

    public Integer getWallet(){
        return wallet;
    }

    //in BasePlayer.java
    public boolean removeFromWallet(Integer amount){
        if(wallet - amount >= 0 ){
            wallet -= amount;
            return true;
        }else
            return false;
    }



    public boolean getOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public void printChar(Console console){
        console.println("====================\nName: " + this.getName() + "\nCash: $" + this.getWallet() + "\n====================");
    }
}

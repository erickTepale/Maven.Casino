package io.zipcoder.casino.utilities;

public  class BasePlayer {
    private Integer wallet;
    private String name;

    public BasePlayer(){}

    public BasePlayer(String name) {
        this.name = name;
        this.wallet = 100000;
    }

    public String getName() {
        return name;
    }
}

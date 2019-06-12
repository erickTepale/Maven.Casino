package io.zipcoder.casino.utilities;

public  class BasePlayer {
    private Integer wallet;
    private String name;


    public BasePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

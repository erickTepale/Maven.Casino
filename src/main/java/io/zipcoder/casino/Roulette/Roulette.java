package io.zipcoder.casino.Roulette;
import java.util.Random;

import io.zipcoder.casino.utilities.BasePlayer;
import io.zipcoder.casino.utilities.GamblingGame;

public class Roulette implements GamblingGame {

    public class Roulette implements GamblingGame {
        private Random random;
        private RoulettePlayer player;
        private RoulettePlayer dealer;

        //Don't think I'm going to need the final colors. The num arrays should do.
        public static final String RED = "red";
        public static final String BLACK = "black";
        public static final String GREEN = "green";
        public static final int[] blacknums = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 27, 29, 31, 33, 35};
        public static final int[] rednums = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};

        private int myValue;
        private String myColor;
        private Random myRoll;
        private BasePlayer base;

        public Roulette(BasePlayer player, BasePlayer dealer) {
            this.player = (RoulettePlayer) player;
            this.dealer = (RoulettePlayer) dealer;
        }

        //Need a method to "spin the wheel"--> generate a random number between 0 and 36.
        //Need a method to generate a random color (red/black/green).
        //Can possibly equate colors to numbers as finals.
        //Need a method to determine whether number is even or odd.
        //Need sout to explain winner gain ratios.




        public String getColor() {
            return myColor;
        }


        public void placeWager() {

        }

        public void increaseMinBet() {

        }

        public void decreaseMinBet() {

        }

        public Integer getNumber(){

            Random random = new Random();
            Integer num = random.nextInt(36) + 1;
            return num;
        }

        public String getColor(Integer num) {
            if (num % 2 == 0 && num != 0) {
                return RED;
            } return BLACK;
        }

        public String getSpin() {
            Roulette roulette = new Roulette(dealer, player);
            Object[] spin  = roulette.getNumber(),
            return

        }

}

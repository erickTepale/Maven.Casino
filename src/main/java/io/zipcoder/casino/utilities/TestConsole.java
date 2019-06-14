package io.zipcoder.casino.utilities;

import java.io.IOException;
import java.util.ArrayList;

public class TestConsole implements ConsoleIO {

    public ArrayList<String> history = new ArrayList<>();
    private Integer counter = 0;
    private Boolean failed = false;
    private Integer failedat = -1;

    public TestConsole(ArrayList<String> expected) {
        this.history = expected;
    }

    public Boolean failed() {
        return this.failed;
    }
    public Integer failedAt() {
        return this.failedat;
    }
    public Integer isFailed() {
        if (this.failed) return this.failedat;
        return -1;
    }

    public void print(String val, Object... args) {
        String actual = String.format(val, args);
        String expected = history.get(counter);
        counter++;
        if (actual.compareTo(expected) != 0) {
            this.failed = true;
            this.failedat = counter -1;

        }
    };
    public void println(String val, Object... vals) {
        String s = String.format(val, vals);
        history.add(s);
    };


    public String getStringInput(String prompt, Object... args) {
        if (prompt != history.get(counter)) {
            // set fail
        }
        counter++;
        String result = history.get(counter);
        return result;
    }

}

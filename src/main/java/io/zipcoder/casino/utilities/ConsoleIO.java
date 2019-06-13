package io.zipcoder.casino.utilities;

public interface ConsoleIO {

        public void print(String val, Object... args);
        public void println(String val, Object... vals);
        public String getStringInput(String prompt, Object... args);
}

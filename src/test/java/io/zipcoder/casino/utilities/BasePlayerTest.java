package io.zipcoder.casino.utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasePlayerTest {

    @Test
    public void getName() {

        BasePlayer test = new BasePlayer("Test");

        assertEquals("Test",test.getName());

    }
}
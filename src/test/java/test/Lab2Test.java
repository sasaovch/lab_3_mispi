package test;

import org.junit.Test;

import static org.junit.Assert.fail;

public class Lab2Test {
    @Test
    public void testNothing() {
    }

    @Test
    public void testWillAlwaysFail() {
        fail("An error message");
    }
}

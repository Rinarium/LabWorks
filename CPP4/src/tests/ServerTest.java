package tests;

import calculator.model.Server;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * This class contains tests of calculation module.
 */
//Check:OFF: MagicNumber
public class ServerTest {

    /**
     * Field holds method in which calculations are made.
     */
    private Server server;

    /**
     * Field holds result of calculation.
     */
    private AtomicInteger result;

    /**
     * Testing correct work with valid values.
     */
    @org.junit.Test
    public void calculateNormal() {
        result =  new AtomicInteger(0);
        server = new Server(500, 0, 200, result);
        assertTrue(server.calculate());
    }

    /**
     * Testing correct work with zero value.
     */
    @org.junit.Test
    public void calculateNull() {
        result =  new AtomicInteger(0);
        server = new Server(0, 2, 545, result);
        assertTrue(server.calculate());
    }

    /**
     * Testing correct work with invalid value (division by zero).
     */
    @org.junit.Test
    public void calculateDivisionNull() {
        result =  new AtomicInteger(0);
        server = new Server(100, 3, 0, result);
        assertFalse(server.calculate());
    }

    /**
     * Testing correct work with not initialized object.
     */
    @org.junit.Test
    public void calculateNullElement() {
        server = new Server(100, 3, 25, null);
        assertFalse(server.calculate());
    }

    /**
     * Testing correct work with invalid request (not existing operation).
     */
    @org.junit.Test
    public void calculateInvalidOperation() {
        result = new AtomicInteger(0);
        server = new Server(150, 6, 10, result);
        assertFalse(server.calculate());
    }

    /**
     * Testing correct work with limit (maximal) values.
     */
    @org.junit.Test
    public void calculateMaximum() {
        result = new AtomicInteger(0);
        server = new Server(Integer.MAX_VALUE, 0, 1, result);
        assertFalse(server.calculate());
    }

    /**
     * Testing correct work with limit (minimal) values.
     */
    @org.junit.Test
    public void calculateMinimum() {
        result = new AtomicInteger(0);
        server = new Server(Integer.MIN_VALUE, 0, 1, result);
        assertFalse(server.calculate());
    }
}
//Check:ON: MagicNumber

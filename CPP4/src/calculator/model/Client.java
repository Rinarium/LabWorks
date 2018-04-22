package calculator.model;


import calculator.controller.Controller;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Client class who sends calculate requests to server.
 */
public class Client implements Runnable {
    /**
     * Left member of mathematics expression.
     */
    private int firstValue;

    /**
     * Right member of mathematics expression.
     */
    private int secondValue;

    /**
     * Sign of mathematics expression.
     */
    private int operation;

    /**
     * Result of mathematics expression.
     */
    private AtomicInteger result;

    /**
     * Identification number of each client.
     */
    private static int id = 0;

    /**
     * Constructor that fills fields.
     * @param leftValue left member of expression.
     * @param rightValue right member of expression.
     * @param sign sign of expression.
     */
    public Client(final int leftValue, final int sign,
                  final int rightValue) {
        id++;
        this.firstValue = leftValue;
        this.operation = sign;
        this.secondValue = rightValue;
        result = new AtomicInteger(0);
    }

    /**
     * This method sets the algorithm for thread.
     */
    public void run() {
        try {
            Server server = new Server(firstValue, operation,
                    secondValue, result);
            Thread thread = new Thread(server);
            thread.start();
            thread.join();
            Controller.acceptTotal(result.get());
        } catch (InterruptedException exception) {
            System.out.println("Error in synchronization!");
        }
    }

    /**
     * Property of Client class.
     * @return id - identification number.
     */
    public static int getId() {
        return id;
    }

    /**
     * @see Client#getId()
     * @return result - result of expression.
     */
    public AtomicInteger getResult() {
        return result;
    }
}

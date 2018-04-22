package calculator.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Server class calculates and returns result.
 */
public class Server implements Runnable {
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
     * Constructor that fills fields.
     * @param leftValue left member of expression.
     * @param rightValue right member of expression.
     * @param sign sign of expression.
     * @param answer result of expression.
     */
    public Server(final int leftValue, final int sign,
                  final int rightValue, final AtomicInteger answer) {
        this.firstValue = leftValue;
        this.operation = sign;
        this.secondValue = rightValue;
        this.result = answer;
    }

    /**
     * This method sets the algorithm for thread.
     */
    @Override
    public synchronized void run() {
       boolean status = this.calculate();
       if (!status) {
           result.set(Integer.MAX_VALUE);
       }
    }

    /**
     * Choosing type of operation and calculating the result of expression.
     * @return status of operation.
     */
    //Check:OFF: MagicNumber
    public boolean calculate() {
        try {
            if (firstValue < -99 || firstValue > 999) {
                throw new ArithmeticException();
            }
            if (secondValue < -99 || secondValue > 999) {
                throw new ArithmeticException();
            }
            if (operation < 0 || operation > 3) {
                throw new ArithmeticException();
            }
            switch (operation) {
                case 0:
                    result.set(firstValue + secondValue);
                    break;
                case 1:
                    result.set(firstValue - secondValue);
                    break;
                case 2:
                    result.set(firstValue * secondValue);
                    break;
                case 3:
                    result.set(firstValue / secondValue);
                    break;
                default:
                    break;
            }
        } catch (ArithmeticException exception) {
            System.out.println("Arithmetic error!");
            return false;
        } catch (NullPointerException exception) {
            System.out.println("Null pointer error!");
            return false;
        }
        return true;
    }
    //Check:ON: MagicNumber
}

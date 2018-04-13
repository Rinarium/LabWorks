package object;

/**
 * This class contains constant values.
 */
public final class Constants {

    /**
     * Identification number of bread.
     */
    public static final int BREAD_ID = 0;

    /**
     * Taste quality of bread.
     */
    public static final float BREAD_TASTE = 3.4F;

    /**
     * Price of bread.
     */
    public static final float BREAD_PRICE = 1.5F;

    /**
     * Identification number of match.
     */
    public static final int MATCH_ID = 1;

    /**
     * Length quality of match.
     */
    public static final float MATCH_LENGTH = 10;

    /**
     * Price of match.
     */
    public static final float MATCH_PRICE = 0.25F;

    /**
     * Identification number of milk.
     */
    public static final int MILK_ID = 2;

    /**
     * Taste quality of milk.
     */
    public static final float MILK_AMOUNT = 1.0F;

    /**
     * Price of milk.
     */
    public static final float MILK_PRICE = 5.35F;

    /**
     * Max amount of cart.
     */
    public static final int CART_AMOUNT = 10;

    /**
     * Random value of buyer's cash.
     */
    public static final int CASH = 25;

    /**
     * This constructor checks that object of this class will not created.
     */
    private Constants() {
        throw new AssertionError("Creating an object of utility class.");
    }
}

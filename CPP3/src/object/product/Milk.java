package object.product;

import object.Constants;

/**
 * This class is a subspecies of product.
 */
public class Milk extends Product {

    /**
     * This field describe taste of milk.
     */
    private static float amount;

    /**
     * This field describe milk's quantity in the shop.
     */
    private static int quantity = 0;

    /**
     * This constructor fills all fields of object.
     */
    public Milk() {
        price = Constants.MILK_PRICE;
        amount = Constants.MILK_AMOUNT;
        setId(Constants.MILK_ID);
    }

    /**
     * This method return quantity of milk in the shop.
     * @return quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method return taste of milk.
     * @return taste.
     */
    public float getAmount() {
        return amount;
    }

    /**
     * This method return price of milk.
     * @return milk price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method decrement quantity of milk in the shop.
     */
    public static void reduceQuantity() {
        if (quantity != 0) {
            quantity--;
        }
    }

    /**
     * This method increment quantity of milk in the shop.
     */
    public static void incrementQuantity() {
        quantity++;
    }

    /**
     * This method is calling before deleting object.
     * @return text which signalize that milk is drunk.
     */
    public String drink() {
        return "Вкусное молоко";
    }

}

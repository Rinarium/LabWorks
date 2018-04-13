package object.product;

import object.Constants;

/**
 * This class is a subspecies of product.
 */
public class Match extends Product {

    /**
     * This field describe length of match.
     */
    public static float length;

    /**
     * This field describe match's quantity in the shop.
     */
    private static int quantity = 0;

    /**
     * This constructor fills all fields of object.
     */
    public Match() {
        price = Constants.MATCH_PRICE;
        length = Constants.MATCH_LENGTH;
        setId(Constants.MATCH_ID);
    }

    /**
     * This method return quantity of match in the shop.
     * @return quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method return price of match.
     * @return match price.
     */
    public float getPrice() {
        return price;
    }

    /**
     * This method decrement quantity of match in the shop.
     */
    public static void reduceQuantity() {
        if (quantity != 0) {
            quantity--;
        }
    }

    /**
     * This method increment quantity of match in the shop.
     */
    public static void incrementQuantity() {
        quantity++;
    }

    /**
     * This method is calling before deleting object.
     * @return text which signalize that bread is burnt out.
     */
    public String fire() {
        return "Гориим";
    }
}

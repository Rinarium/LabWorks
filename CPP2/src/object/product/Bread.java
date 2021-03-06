package object.product;

import object.Constants;

/**
 * This class is a subspecies of product.
 */
public class Bread extends Product {

    /**
     * This field describe taste of bread.
     */
    private static float taste;

    /**
     * This field describe price of bread.
     */
    private static float breadPrice;

    /**
     * This field describe bread's quantity in the shop.
     */
    private static int quantity = 0;

    /**
     * This constructor fills all fields of object.
     */
    public Bread() {
        breadPrice = Constants.BREAD_PRICE;
        taste = Constants.BREAD_TASTE;
        setId(Constants.BREAD_ID);
        setPrice(breadPrice);
    }

    /**
     * This method return quantity of bread in the shop.
     * @return quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method return taste of bread.
     * @return taste.
     */
    public static float getTaste() {
        return taste;
    }

    /**
     * This method decrement quantity of bread in the shop.
     */
    public static void reduceQuantity() {
        if (quantity != 0) {
            quantity--;
        }
    }

    /**
     * This method increment quantity of bread in the shop.
     */
    public static void incrementQuantity() {
        quantity++;
    }

    /**
     * This method is calling before deleting object.
     * @return text which signalize that bread is eaten.
     */
    public String eat() {
        return "Вкусноо";
    }
}

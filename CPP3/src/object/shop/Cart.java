package object.shop;

import object.product.Product;
import object.Constants;
import java.util.ArrayList;

/**
 * This is class that represents cart in the shop.
 */
public class Cart {

    /**
     * This field contains amount (max quantity of inner products) of cart.
     */
    private int amount;

    /**
     * This field is a list of products that are inside cart.
     */
    private ArrayList<Product> products;

    /**
     * This constructor fills all fields of object.
     */
    public Cart() {
        amount = Constants.CART_AMOUNT;
        products = new ArrayList<>();
    }

    /**
     * This method return current amount of cart.
     * @return amount.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * This method set new amount of cart.
     * @param newAmount is the new amount.
     */
    public void setAmount(final int newAmount) {
        if (newAmount < 0) {
            return;
        } else {
            amount = newAmount;
        }
    }

    /**
     * This method return current list products containing in cart.
     * @return list of products.
     */
    public ArrayList<Product> getProduct() {
        return products;
    }

    /**
     * This method adding another product to the cart.
     * @param product is new product putting in cart.
     */
    public void acceptProduct(final Product product) {
        this.setAmount(this.getAmount() - 1);
        products.add(product);
    }

    /**
     * This method transfer products from cart to buyer.
     * @return list of product that is stored in cart.
     */
    public ArrayList<Product> giveOutProduct() {
        ArrayList<Product> transfer = new ArrayList<>();
        transfer.addAll(products);
        products.clear();
        amount = Constants.CART_AMOUNT;
        return transfer;
    }
}

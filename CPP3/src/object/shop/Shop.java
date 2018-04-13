package object.shop;

import object.product.Bread;
import object.product.Match;
import object.product.Milk;
import object.product.Product;
import object.Constants;

import java.util.ArrayList;

/**
 * This is class that represents shop and its characteristics.
 */
public class Shop {

    /**
     * This field describes name of the shop.
     */
    private String name;

    /**
     * This field contains income of the shop.
     */
    private float income;

    /**
     * This field contains cart in which buyer puts in products.
     */
    private Cart cart;

    /**
     * This field is a list of products that are inside shop.
     */
    private ArrayList<Product> product;

    /**
     * This field is a list of product's ID that are inside shop.
     */
    private ArrayList<Product> productList;

    /**
     * This constructor fills all fields of object.
     * @param newName is shop name.
     */
    public Shop(final String newName) {
        name = newName;
        income = 0;
        cart = new Cart();
        product = new ArrayList<>();
        productList = new ArrayList<>();
        fillList();
    }

    /**
     * This method add new product to the shop by his ID.
     * @param id of product.
     */
    public void addProduct(final int id) {
        if (id == Constants.BREAD_ID) {
            Bread.incrementQuantity();
            product.add(new Bread());
        } else if (id == Constants.MATCH_ID) {
            Match.incrementQuantity();
            product.add(new Match());
        } else {
            Milk.incrementQuantity();
            product.add(new Milk());
        }
    }

    /**
     * This method return list of products.
     * @return list of products.
     */
    public ArrayList<Product> getProduct() {
        return product;
    }

    /**
     * This method return list of products' ID.
     * @return list of products' ID.
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }

    /**
     * This method fills list of products' ID.
     */
    public void fillList() {
        productList.add(new Bread());
        productList.add(new Match());
        productList.add(new Milk());
    }

    /**
     * This method return quantity of products chosen by ID.
     * @param id is specific number of product type.
     * @return quantity of certain product.
     */
    public int countQuantity(final Integer id) {
        int count = 0;
        for (Product products : getProduct()) {
            if (products.getID() == id) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method return income of shop.
     * @return income.
     */
    public float getIncome() {
        return income;
    }

    /**
     * This method return cart.
     * @return cart.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * This method return shop name.
     * @return shop name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is fisrt step to buying product. Check fullness of cart.
     * @return status of cart (there is product in it or not).
     */
    public boolean sell() {
        return cart.getProduct().isEmpty();
    }

    /**
     * This method is counting price of whole products containing in cart.
     * @param cash is available buyer funds.
     * @return total price.
     */
    public float requestMoney(final float cash) {
        float result = 0;

        for (Product products : cart.getProduct()) {
            result += products.getPrice();
        }

        if (result > cash) {
            return cash;
        } else {
            income += result;
            result = cash - result;
            return result;
        }
    }
}

package object.product;

/**
 * This class contains a common characteristics of products.
 */
public class Product {

    /**
     * This field is identification number of product.
     */
    private int id;

    /**
     * This field describe match of bread.
     */
    private float price;

    /**
     * This field describe match's quantity in the shop.
     */
    private int quantity;

    /**
     * This method set new product price.
     * @param newPrice is the new price.
     */
    public void setPrice(final float newPrice) {
        if (newPrice < 0) {
            return;
        }
        price = newPrice;
    }

    /**
     * Property of class Product.
     * @return  price of this product.
     */
    public float getPrice() {
        return price;
    }

    /**
     * @see Product#getPrice()
     * @return quantity of this product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @see Product#getPrice()
     * @return  id - identification number of product.
     */
    public int getID() {
        return id;
    }

    /**
     * Property of class Product.
     * @param  newID - identification number of product.
     */
    public void setId(final int newID) {
        this.id = newID;
    }
}


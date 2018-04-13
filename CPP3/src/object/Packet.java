package object;

import object.product.Product;
import java.util.ArrayList;

/**
 * This is class that represents packet in the shop.
 */
public class Packet {

    /**
     * This field is a list of products that are inside packet.
     */
    private ArrayList<Product> products;

    /**
     * This constructor fills all fields of object.
     */
    public Packet() {
        products = new ArrayList<>();
    }

    /**
     * Property of class GUI.
     * @return list of products that contain in packet
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * This method receive products from buyer.
     * @param newProducts - products that's coming from buyer.
     */
    public void acceptProduct(final ArrayList<Product> newProducts) {
        products.addAll(newProducts);
    }

    /**
     * This method transfer products from packet to receiver.
     * @return list of products.
     */
    public ArrayList<Product> giveOutProducts() {
        ArrayList<Product> transfer = new ArrayList<>();
        transfer.addAll(products);
        products.clear();
        return transfer;
    }
}

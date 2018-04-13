package object;

import main.GUI;
import object.product.Bread;
import object.product.Match;
import object.product.Milk;
import object.product.Product;
import object.shop.Cart;
import object.shop.Shop;
import java.util.ArrayList;

/**
 * This is class that represents buyer and his characteristics.
 */
public class Buyer {

    /**
     * This field contains available buyer funds.
     */
    private float cash;

    /**
     * This field contains product that buyer is holding in his hand.
     */
    private Product productInHand;

    /**
     * This field contains products that is bought by buyer.
     */
    private ArrayList<Product> mainProduct;

    /**
     * This constructor fills all fields of object.
     */
    public Buyer() {
        cash = Constants.CASH;
        productInHand = null;
        mainProduct = new ArrayList<>();
    }

    /**
     * This method transfer product from shop to buyer's hand.
     * @param product from shop.
     * @return status of operation.
     */
    public boolean takeProduct(final Product product) {
        if (productInHand == null) {
            productInHand = product;
            return true;
        }
        GUI.warning("Товар уже в руке!");
        return false;
    }

    /**
     * This method releases buyer's hand.
     */
    public void freeHand() {
        productInHand = null;
    }

    /**
     * Property of class GUI.
     * @return cash.
     */
    public float getCash() {
        return cash;
    }

    /**
     * @see Buyer#getCash()
     * @return product that is in buyer's hand.
     */
    public Product getProductInHand() {
        return productInHand;
    }

    /**
     * @see Buyer#getCash()
     * @return list of bought products.
     */
    public ArrayList<Product> getMainProduct() {
        return mainProduct;
    }

    /**
     * This method transfer product from buyer's hand to cart.
     * @param cart is cart of shop.
     * @return status of operation.
     */
    public boolean putToCart(final Cart cart) {
        if (cart.getAmount() == 0) {
            GUI.warning("Тележка заполнена!");
            return false;
        }
        if (productInHand == null) {
            GUI.warning("Нечего класть!");
            return false;
        }
        cart.acceptProduct(productInHand);
        productInHand = null;
        return true;
    }

    /**
     * This method transfer product from buyer to packet.
     * @param packet is main buyer packet.
     * @return status of operation.
     */
    public boolean putToPacket(final Packet packet) {
        if (mainProduct.isEmpty()) {
            return false;
        } else {
            packet.acceptProduct(mainProduct);
            mainProduct.clear();
        }
        return true;
    }

    /**
     * This method transfer product from packet to buyer.
     * @param packet is main buyer packet.
     * @return status of operation.
     */
    public boolean receiveFromPacket(final Packet packet) {
        if (packet.getProducts().isEmpty()) {
            return false;
        } else {
            ArrayList<Product> transfer = new ArrayList<>();
            transfer.addAll(packet.giveOutProducts());
            mainProduct.addAll(transfer);
        }
        return true;
    }

    /**
     * Property of GUI class.
     * @param newMainProduct - list of new bought products.
     */
    public void setMainProduct(final ArrayList<Product> newMainProduct) {
        this.mainProduct = newMainProduct;
    }

    /**
     * This method passes exchange between shop (products) and buyer (money).
     * @param shop - products owner.
     * @return status of operation.
     */
    public boolean buyProduct(final Shop shop) {
        boolean check = shop.sell();

        if (check) {
            GUI.warning("Тележка пуста!");
            return false;
        } else {
            float total = shop.requestMoney(cash);

            if (cash != total) {
                cash = total;

                ArrayList<Product> purchase = shop.getCart().giveOutProduct();
                mainProduct.addAll(purchase);
                return true;
            } else {
                GUI.warning("Недостаточно средств!");
            }
        }

        return false;
    }

    /**
     * Property of GUI class.
     * @param id - identification number of product that want to consume buyer.
     * @return text which signalize that product is consumed.
     */
    public String consume(final int id) {
        Product consuming = null;
        for (Product product : mainProduct) {
            if (product.getID() == id) {
                consuming = product;
                break;
            }
        }

        if (consuming == null) {
            return null;
        }

        String total;

        switch (id) {
            case Constants.BREAD_ID: Bread bread = (Bread) consuming;
                                     total = bread.eat();
                                     mainProduct.remove(bread);
                                     return total;
            case Constants.MATCH_ID: Match match = (Match) consuming;
                                     total = match.fire();
                                     mainProduct.remove(match);
                                     return total;
            case Constants.MILK_ID:  Milk milk = (Milk) consuming;
                                     total = milk.drink();
                                     mainProduct.remove(milk);
                                     return total;
            default:
        }
        return null;
    }
}

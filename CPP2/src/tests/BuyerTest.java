package tests;

import object.Buyer;
import object.product.Match;
import object.product.Product;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This class contains tests of buyer's modules.
 */
public class BuyerTest {

    /**
     * Test buyer.
     */
    private Buyer buyer = new Buyer();

    /**
     * Test set of product for buyer.
     */
    private ArrayList<Product> mainProduct = new ArrayList<>();

    /**
     * Testing with normal working of method.
     */
    @Test
    public void consumeString() {
        mainProduct.add(new Match());
        buyer.setMainProduct(mainProduct);
        assertEquals("Гориим", buyer.consume(1));
    }

    /**
     * Testing method without adding any product to buyer.
     */
    @Test
    public void consumeNulls() {
        buyer.setMainProduct(mainProduct);
        assertNull(buyer.consume(1));
    }

    /**
     * Testing method with adding a product different from that requested
     * by the buyer.
     */
    @Test
    public void consumeOtherProduct() {
        mainProduct.add(new Match());
        buyer.setMainProduct(mainProduct);
        assertNull(buyer.consume(0));
    }
}

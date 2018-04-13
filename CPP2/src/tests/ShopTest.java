package tests;

import object.product.Bread;
import object.product.Match;
import object.shop.Shop;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class contains tests of shop's modules.
 */
//Check:OFF: MagicNumber
public class ShopTest {

    /**
     * Test shop.
     */
    private Shop shop = new Shop("");

    /**
     * Testing with normal working of method.
     */
    @Test
    public void requestMoneyNormalValues() {
        shop.getCart().getProduct().add(new Bread());
        assertEquals(0.5F, shop.requestMoney(2.0F), 0.0);
    }

    /**
     * Testing with sending negative value of cash.
     */
    @Test
    public void requestMoneyNegative() {
        shop.getCart().getProduct().add(new Bread());
        assertEquals(-2.0F, shop.requestMoney(-2.0F), 0.0);
    }

    /**
     * Testing with sending null cash.
     */
    @Test
    public void requestMoneyNull() {
        shop.getCart().getProduct().add(new Bread());
        assertEquals(0F, shop.requestMoney(0F), 0.0);
    }

    /**
     * Testing with sending infinity instead of cash.
     */
    @Test
    public void requestMoneyInfinite() {
        shop.getCart().getProduct().add(new Match());
        assertEquals((float) Double.POSITIVE_INFINITY,
                shop.requestMoney((float) Double.POSITIVE_INFINITY),
                0.0);
    }
}
//Check:ON: MagicNumber

package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.buffaloMeat.BuffaloMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuffaloMeatTest {
    BuffaloMeat M = new BuffaloMeat();

    @Test
    public void BuffaloMeatValueTest() {
        System.out.println("BuffaloMeat value test");
        assertEquals(M.getHarga(), 70000);
    }
}
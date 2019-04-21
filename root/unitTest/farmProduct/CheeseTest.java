package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.cheese.Cheese;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheeseTest {
    Cheese C = new Cheese();

    @Test
    public void CheeseValueTest() {
        System.out.println("Cheese value test");
        assertEquals(C.getHarga(), 15000);
    }
}
package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChickenEggTest {
    ChickenEgg M = new ChickenEgg();

    @Test
    public void chickenEggValueTest() {
        System.out.println("ChickenEgg value test");
        assertEquals(M.getHarga(), 3000);
    }
}
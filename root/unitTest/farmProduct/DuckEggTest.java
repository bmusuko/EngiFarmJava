package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.egg.duckEgg.DuckEgg;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DuckEggTest {
    DuckEgg M = new DuckEgg();

    @Test
    public void DuckEggValueTest() {
        System.out.println("DuckEgg value test");
        assertEquals(M.getHarga(), 3000);
    }
}
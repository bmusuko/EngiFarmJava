package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.duckMeat.DuckMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DuckMeatTest {
    DuckMeat M = new DuckMeat();

    @Test
    public void DuckMeatValueTest() {
        System.out.println("DuckMeat value test");
        assertEquals(M.getHarga(), 70000);
    }
}
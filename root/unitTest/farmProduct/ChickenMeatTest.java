package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.chickenMeat.ChickenMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChickenMeatTest {
    ChickenMeat M = new ChickenMeat();

    @Test
    public void ChickenMeatValueTest() {
        System.out.println("ChickenMeat value test");
        assertEquals(M.getHarga(), 70000);
    }
}
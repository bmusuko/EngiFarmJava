package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.cowMeat.CowMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CowMeatTest {
    CowMeat M = new CowMeat();

    @Test
    public void CowMeatValueTest() {
        System.out.println("CowMeat value test");
        assertEquals(M.getHarga(), 120000);
    }
}
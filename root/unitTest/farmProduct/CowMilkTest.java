package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.milk.cowMilk.CowMilk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CowMilkTest {
    CowMilk M = new CowMilk();

    @Test
    public void CowMilkValueTest() {
        System.out.println("CowMilk value test");
        assertEquals(M.getHarga(), 20000);
    }
}
package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.goatMeat.GoatMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GoatMeatTest {
    GoatMeat M = new GoatMeat();

    @Test
    public void GoatMeatValueTest() {
        System.out.println("GoatMeat value test");
        assertEquals(M.getHarga(), 120000);
    }
}
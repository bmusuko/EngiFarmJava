package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.milk.goatMilk.GoatMilk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GoatMilkTest {
    GoatMilk M = new GoatMilk();

    @Test
    public void GoatMilkValueTest() {
        System.out.println("GoatMilk value test");
        assertEquals(M.getHarga(), 80000);
    }
}
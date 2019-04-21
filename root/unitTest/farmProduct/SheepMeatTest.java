package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.meat.sheepMeat.SheepMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SheepMeatTest {
    SheepMeat M = new SheepMeat();

    @Test
    public void SheepMeatValueTest() {
        System.out.println("SheepMeat value test");
        assertEquals(M.getHarga(), 12000);
    }
}
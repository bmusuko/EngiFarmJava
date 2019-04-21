package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.beefRolade.BeefRolade;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BeefRoladeTest {
    BeefRolade BR = new BeefRolade();

    @Test
    public void beefRoladeValueTest() {
        System.out.println("BeefRolade value test");
        assertEquals(BR.getHarga(), 20000);
    }
}
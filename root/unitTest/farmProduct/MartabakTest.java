package unitTest.farmProduct;

import model.farmProduct.Product;
import model.farmProduct.martabak.Martabak;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MartabakTest {
    Martabak M = new Martabak();

    @Test
    public void MartabakValueTest() {
        System.out.println("Martabak value test");
        assertEquals(M.getHarga(), 30000);
    }
}
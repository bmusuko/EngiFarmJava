package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.buffalo.Buffalo;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.buffaloMeat.BuffaloMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BuffaloTest {
    Buffalo B = new Buffalo(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Buffalo move test");
        assertEquals(B.getX(), 0);
        assertEquals(B.getY(), 0);
        B.move(2, 1);
        assertEquals(B.getX(), 2);
        assertEquals(B.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Buffalo eat test");
        B.eat();
        assertEquals(B.getLapar(), 14);
        assertEquals(B.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Buffalo lapar test");
        B.setLapar(0);
        assertEquals(B.isLapar(), true);
        B.eat();
        assertEquals(B.isLapar(), false);
    }

    @Test
    public void respondKillTest() {
        System.out.println("Buffalo respondKill test");
        BuffaloMeat BM = new BuffaloMeat();
        assertEquals(B.respondKill().getClass().getSimpleName(), BM.getClass().getSimpleName());
    }
}
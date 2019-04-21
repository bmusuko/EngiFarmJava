package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.duck.Duck;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.duckMeat.DuckMeat;
import model.farmProduct.egg.duckEgg.DuckEgg;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DuckTest {
    Duck D = new Duck(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Duck move test");
        assertEquals(D.getX(), 0);
        assertEquals(D.getY(), 0);
        D.move(2, 1);
        assertEquals(D.getX(), 2);
        assertEquals(D.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Duck eat test");
        D.eat();
        assertEquals(D.getLapar(), 6);
        assertEquals(D.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Duck lapar test");
        D.setLapar(0);
        assertEquals(D.isLapar(), true);
        D.eat();
        assertEquals(D.isLapar(), false);
    }

    @Test
    public void hasilProductTest() {
        System.out.println("Duck hasilProduct test");
        D.setHasilProduct(false);
        assertEquals(D.getHasilProduct(), false);
    }

    @Test
    public void respondInteractTest() {
        System.out.println("Duck respondInteract test");
        D.setHasilProduct(false);
        assertEquals(D.respondInteract(), null);
        DuckEgg DE = new DuckEgg();
        D.setHasilProduct(true);
        assertEquals(D.respondInteract().getClass().getSimpleName(), DE.getClass().getSimpleName());
    }

    @Test
    public void respondKillTest() {
        System.out.println("Duck respondKill test");
        DuckMeat DM = new DuckMeat();
        assertEquals(D.respondKill().getClass().getSimpleName(), DM.getClass().getSimpleName());
    }
}
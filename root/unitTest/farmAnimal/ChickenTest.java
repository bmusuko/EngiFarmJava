package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.chicken.Chicken;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.chickenMeat.ChickenMeat;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ChickenTest {
    Chicken C = new Chicken(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Chicken move test");
        assertEquals(C.getX(), 0);
        assertEquals(C.getY(), 0);
        C.move(2, 1);
        assertEquals(C.getX(), 2);
        assertEquals(C.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Chicken eat test");
        C.eat();
        assertEquals(C.getLapar(), 5);
        assertEquals(C.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Chicken lapar test");
        C.setLapar(0);
        assertEquals(C.isLapar(), true);
        C.eat();
        assertEquals(C.isLapar(), false);
    }

    @Test
    public void hasilProductTest() {
        System.out.println("Chicken hasilProduct test");
        C.setHasilProduct(false);
        assertEquals(C.getHasilProduct(), false);
    }

    @Test
    public void respondInteractTest() {
        System.out.println("Chicken respondInteract test");
        C.setHasilProduct(false);
        assertEquals(C.respondInteract(), null);
        ChickenEgg CE = new ChickenEgg();
        C.setHasilProduct(true);
        assertEquals(C.respondInteract().getClass().getSimpleName(), CE.getClass().getSimpleName());
    }

    @Test
    public void respondKillTest() {
        System.out.println("Chicken respondKill test");
        ChickenMeat CM = new ChickenMeat();
        assertEquals(C.respondKill().getClass().getSimpleName(), CM.getClass().getSimpleName());
    }
}
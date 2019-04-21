package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.cow.Cow;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.cowMeat.CowMeat;
import model.farmProduct.milk.cowMilk.CowMilk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CowTest {
    Cow C = new Cow(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Cow move test");
        assertEquals(C.getX(), 0);
        assertEquals(C.getY(), 0);
        C.move(2, 1);
        assertEquals(C.getX(), 2);
        assertEquals(C.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Cow eat test");
        C.eat();
        assertEquals(C.getLapar(), 15);
        assertEquals(C.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Cow lapar test");
        C.setLapar(0);
        assertEquals(C.isLapar(), true);
        C.eat();
        assertEquals(C.isLapar(), false);
    }

    @Test
    public void hasilProductTest() {
        System.out.println("Cow hasilProduct test");
        C.setHasilProduct(false);
        assertEquals(C.getHasilProduct(), false);
    }

    @Test
    public void respondInteractTest() {
        System.out.println("Cow respondInteract test");
        C.setHasilProduct(false);
        assertEquals(C.respondInteract(), null);
        CowMilk CE = new CowMilk();
        C.setHasilProduct(true);
        assertEquals(C.respondInteract().getClass().getSimpleName(), CE.getClass().getSimpleName());
    }

    @Test
    public void respondKillTest() {
        System.out.println("Cow respondKill test");
        CowMeat CM = new CowMeat();
        assertEquals(C.respondKill().getClass().getSimpleName(), CM.getClass().getSimpleName());
    }
}
package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.goat.Goat;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.goatMeat.GoatMeat;
import model.farmProduct.milk.goatMilk.GoatMilk;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GoatTest {
    Goat G = new Goat(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Goat move test");
        assertEquals(G.getX(), 0);
        assertEquals(G.getY(), 0);
        G.move(2, 1);
        assertEquals(G.getX(), 2);
        assertEquals(G.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Goat eat test");
        G.eat();
        assertEquals(G.getLapar(), 10);
        assertEquals(G.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Goat lapar test");
        G.setLapar(0);
        assertEquals(G.isLapar(), true);
        G.eat();
        assertEquals(G.isLapar(), false);
    }

    @Test
    public void hasilProductTest() {
        System.out.println("Goat hasilProduct test");
        G.setHasilProduct(false);
        assertEquals(G.getHasilProduct(), false);
    }

    @Test
    public void respondInteractTest() {
        System.out.println("Goat respondInteract test");
        G.setHasilProduct(false);
        assertEquals(G.respondInteract(), null);
        GoatMilk GE = new GoatMilk();
        G.setHasilProduct(true);
        assertEquals(G.respondInteract().getClass().getSimpleName(), GE.getClass().getSimpleName());
    }

    @Test
    public void respondKillTest() {
        System.out.println("Goat respondKill test");
        GoatMeat GM = new GoatMeat();
        assertEquals(G.respondKill().getClass().getSimpleName(), GM.getClass().getSimpleName());
    }
}
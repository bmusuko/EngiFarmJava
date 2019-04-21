package unitTest.farmAnimal;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.animal.sheep.Sheep;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.sheepMeat.SheepMeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SheepTest {
    Sheep S = new Sheep(0, 0);

    @Test
    public void moveTest() {
        System.out.println("Sheep move test");
        assertEquals(S.getX(), 0);
        assertEquals(S.getY(), 0);
        S.move(2, 1);
        assertEquals(S.getX(), 2);
        assertEquals(S.getY(), 1);
    }

    @Test
    public void eatTest() {
        System.out.println("Sheep eat test");
        S.eat();
        assertEquals(S.getLapar(), 12);
        assertEquals(S.getHasilProduct(), true);
    }

    @Test
    public void laparTest() {
        System.out.println("Sheep lapar test");
        S.setLapar(0);
        assertEquals(S.isLapar(), true);
        S.eat();
        assertEquals(S.isLapar(), false);
    }

    @Test
    public void respondKillTest() {
        System.out.println("Sheep respondKill test");
        SheepMeat SM = new SheepMeat();
        assertEquals(S.respondKill().getClass().getSimpleName(), SM.getClass().getSimpleName());
    }
}
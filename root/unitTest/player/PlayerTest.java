package unitTest.player;

import model.player.Player;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.barn.Barn;
import model.facility.Facility;
import model.facility.mixer.Mixer;
import model.facility.truck.Truck;
import model.facility.well.Well;
import model.farmProduct.Product;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.animal.chicken.Chicken;
import model.farmAnimal.animal.cow.Cow;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import model.farmProduct.milk.cowMilk.CowMilk;
import model.farmProduct.egg.duckEgg.DuckEgg;
import model.farmProduct.martabak.Martabak;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player P = new Player(2, 2);

    @Test
    public void wadahAirTest() {
        System.out.println("Player wadahAir test");
        assertEquals(10, P.getWadahAir());
    }

    @Test
    public void tasTest() {
        System.out.println("Player tas test");
        ChickenEgg CE = new ChickenEgg();
        CowMilk CM = new CowMilk();
        P.addElTas(new ChickenEgg());
        P.addElTas(new ChickenEgg());
        for (int i = 0; i < P.getTas().size(); i++) {
            assertEquals(CE.getClass().getSimpleName(), P.getIsiTas(i).getClass().getSimpleName());
        }
        P.delElTas(CE);
        P.delElTas(CE);
        P.addElTas(new CowMilk());
        // assertEquals(CM.getClass().getSimpleName(),
        // P.getIsiTas(0).getClass().getSimpleName());
        for (int i = 0; i < P.getTas().size(); i++) {
            System.out.println(P.getIsiTas(i).getClass().getSimpleName());
        }
        P.delElTas(CM);
    }

    @Test
    public void moneyTest() {
        System.out.println("Player money test");
        assertEquals(0, P.getMoney());
        P.setMoney(1000);
        assertEquals(1000, P.getMoney());
    }

    @Test
    public void moveTest() {
        System.out.println("Player move test");
        assertEquals(2, P.getPosisiX());
        assertEquals(2, P.getPosisiY());
        P.move(1);
        assertEquals(1, P.getPosisiX());
        assertEquals(2, P.getPosisiY());
        P.move(2);
        assertEquals(1, P.getPosisiX());
        assertEquals(3, P.getPosisiY());
        P.move(3);
        assertEquals(2, P.getPosisiX());
        assertEquals(3, P.getPosisiY());
        P.move(4);
        assertEquals(2, P.getPosisiX());
        assertEquals(2, P.getPosisiY());
    }

    @Test
    public void growTest() {
        System.out.println("Player grow test");
        Barn B = new Barn(2, 2, false, false);
        P.grow(B);
        assertEquals(true, B.getIsGrassExist());
        assertEquals(9, P.getWadahAir());
    }

    @Test
    public void animalInteractEggTest() {
        System.out.println("Player interact eggProducingAnimal test");
        Chicken C = new Chicken(2, 3);
        C.eat();
        P.interact(C);
        assertEquals(new ChickenEgg().getClass().getSimpleName(), P.getIsiTas(0).getClass().getSimpleName());
        P.delElTas(new ChickenEgg());
    }

    @Test
    public void animalInteractMilkTest() {
        System.out.println("Player interact milkProducingAnimal test");
        Cow C = new Cow(2, 1);
        C.eat();
        P.interact(C);
        assertEquals(new CowMilk().getClass().getSimpleName(), P.getIsiTas(0).getClass().getSimpleName());
        P.delElTas(new CowMilk());
    }

    @Test
    public void facilityInteractMixerTest() {
        System.out.println("Player interact mixer test");
        Mixer M = new Mixer(2, 1);
        P.addElTas(new DuckEgg());
        P.addElTas(new ChickenEgg());
        P.interact(M);
        assertEquals(new Martabak().getClass().getSimpleName(), P.getIsiTas(0).getClass().getSimpleName());
        P.delElTas(new Martabak());
    }

    @Test
    public void facilityInteractTruckTest() {
        System.out.println("Player interact truck test");
        Truck T = new Truck(2, 1);
        T.minCD();
        T.minCD();
        T.minCD();
        T.minCD();
        T.minCD();
        P.addElTas(new DuckEgg());
        P.addElTas(new ChickenEgg());
        P.interact(T);
        assertEquals(0, P.getTas().size());
        assertEquals(23000, P.getMoney());
    }

    @Test
    public void facilityInteractWellTest() {
        System.out.println("Player interact well test");
        Well W = new Well(2, 1);
        P.setWadahAir(2);
        P.interact(W);
        assertEquals(10, P.getWadahAir());
    }
}
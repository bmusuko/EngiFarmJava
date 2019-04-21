package unitTest.facility;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import model.facility.Facility;
import model.facility.mixer.Mixer;
import model.farmProduct.*;
import model.farmProduct.egg.chickenEgg.*;
import model.farmProduct.egg.duckEgg.*;
import model.farmProduct.meat.cowMeat.*;
import model.farmProduct.milk.cowMilk.*;
import model.farmProduct.milk.goatMilk.*;
import model.farmProduct.beefRolade.*;
import model.farmProduct.cheese.*;
import model.farmProduct.martabak.*;

public class MixerTest {
    Mixer M = new Mixer(0, 0);

    @Test
    public void isInventAvailTest() {
        System.out.println("Mixer isInventAvailable Test");
        LinkedList<Product> LP1 = new LinkedList<Product>();
        LP1.add(new CowMilk());
        LP1.add(new GoatMilk());
        LP1.add(new ChickenEgg());
        assertEquals(M.isInventAvailable(LP1, new CowMilk(), new GoatMilk()), true);
        assertEquals(M.isInventAvailable(LP1, new ChickenEgg(), new DuckEgg()), false);
    }

    @Test
    public void deleteNeededInventTest() {
        System.out.println("Mixer deleteNeededInvent Test");
        LinkedList<Product> LP1 = new LinkedList<Product>();
        LinkedList<Product> LP2 = new LinkedList<Product>();
        LP1.add(new CowMilk());
        LP1.add(new GoatMilk());
        LP1.add(new ChickenEgg());
        LP1.add(new CowMilk());
        LP1.add(new DuckEgg());
        LP1 = M.deleteNeededPoduct(LP1, new ChickenEgg(), new DuckEgg());
        LP2.add(new CowMilk());
        LP2.add(new GoatMilk());
        LP2.add(new CowMilk());
        for (int i = 0; i < 3; i++) {
            assertEquals(LP1.get(i).getClass().getSimpleName(), LP1.get(i).getClass().getSimpleName());
        }
    }

    @Test
    public void createMartabakTest() {
        System.out.println("Mixer createMartabak Test");
        LinkedList<Product> LP1 = new LinkedList<Product>();
        LinkedList<Product> LP2 = new LinkedList<Product>();
        LP1.add(new ChickenEgg());
        LP1.add(new DuckEgg());
        M.createMartabak(LP1);
        LP2.add(new Martabak());
        assertEquals(LP1.get(0).getClass().getSimpleName(), LP1.get(0).getClass().getSimpleName());
    }

    @Test
    public void createCheeseTest() {
        System.out.println("Mixer createCheese Test");
        LinkedList<Product> LP1 = new LinkedList<Product>();
        LinkedList<Product> LP2 = new LinkedList<Product>();
        LP1.add(new CowMilk());
        LP1.add(new GoatMilk());
        M.createCheese(LP1);
        LP2.add(new Cheese());
        assertEquals(LP1.get(0).getClass().getSimpleName(), LP1.get(0).getClass().getSimpleName());
    }

    @Test
    public void createBeefRoladeTest() {
        System.out.println("Mixer createBeefRolade Test");
        LinkedList<Product> LP1 = new LinkedList<Product>();
        LinkedList<Product> LP2 = new LinkedList<Product>();
        LP1.add(new ChickenEgg());
        LP1.add(new CowMeat());
        M.createBeefRolade(LP1);
        LP2.add(new BeefRolade());
        assertEquals(LP1.get(0).getClass().getSimpleName(), LP1.get(0).getClass().getSimpleName());
    }

}
package unitTest.facility;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.facility.Facility;
import model.facility.truck.Truck;
import model.farmProduct.*;
import model.farmProduct.egg.chickenEgg.*;
import model.farmProduct.egg.duckEgg.*;
import model.farmProduct.meat.cowMeat.*;
import model.farmProduct.milk.cowMilk.*;
import model.farmProduct.milk.goatMilk.*;
import model.player.Player;

public class TruckTest {
    public Truck T = new Truck(0, 0);
    public Player P = new Player(0, 1);

    @Test
    public void useTest() {
        GoatMilk GM = new GoatMilk();
        T.minCD();
        T.minCD();
        T.minCD();
        T.minCD();
        T.minCD();
        T.minCD();
        System.out.println("Truck use Test");
        P.addElTas(new ChickenEgg());
        P.addElTas(new CowMeat());
        P.addElTas(new CowMilk());
        T.use(P);
        P.addElTas(new GoatMilk());
        assertEquals(P.getIsiTas(0).getClass().getSimpleName(), GM.getClass().getSimpleName());
    }
}
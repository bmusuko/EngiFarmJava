package model;

import model.player.Player;
import model.facility.Facility;
import model.facility.mixer.Mixer;
import model.facility.truck.Truck;
import model.facility.well.Well;
import model.farmProduct.meat.cowMeat.CowMeat;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import model.farmProduct.egg.duckEgg.DuckEgg;

public class PlayerTest {
    public static void main(String args[]) {
        Player P = new Player(0, 0);
        Truck T = new Truck(0, 0);
        Mixer M = new Mixer(0, 1);
        P.displayStatus();
        P.addElTas(new CowMeat());
        P.addElTas(new ChickenEgg());
        P.addElTas(new ChickenEgg());
        P.addElTas(new DuckEgg());
        P.displayStatus();
        P.interact(M);
        P.displayStatus();
        // interact ke facility sama grow udah di tes
    }
}
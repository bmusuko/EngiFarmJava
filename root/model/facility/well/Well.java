package model.facility.well;

import model.facility.Facility;
import model.player.Player;

public class Well extends Facility {
    public Well(int X, int Y) {
        super(X, Y);
    }

    public void use(Player P) {
        System.out.println("Wadah air anda sudah terisi penuh!");
        P.setWadahAir(10);
    }

    public char displaySymbol() {
        return 'W';
    }
}
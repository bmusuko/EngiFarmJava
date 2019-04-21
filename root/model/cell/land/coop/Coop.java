package model.cell.land.coop;

import model.cell.land.Land;

public class Coop extends Land {
    public Coop(int X, int Y, boolean object, boolean grass) {
        super(X, Y, object, grass);
    }

    public char displaySymbol() {
        if (isGrassExist) {
            return '#';
        } else {
            return 'o';
        }
    }
}
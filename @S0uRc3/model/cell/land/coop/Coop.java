package model.cell.land.coop;

import model.cell.land.Land;

class Coop extends Land {
    Coop(int X, int Y, boolean object, boolean grass) {
        super(X, Y, object, grass);
    }

    public char displaySymbol() {
        if (isGrassExist) {
            return 'o';
        } else {
            return '#';
        }
    }
}
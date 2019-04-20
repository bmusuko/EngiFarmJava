package model.cell.land.grassLand;

import model.cell.land.Land;

class Grassland extends Land {
    Grassland(int X, int Y, boolean object, boolean grass) {
        super(X, Y, object, grass);
    }

    public char displaySymbol() {
        if (isGrassExist) {
            return '*';
        } else {
            return '-';
        }
    }
}
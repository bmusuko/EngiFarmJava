package model.facility;

import model.cell.Cell;
import model.player.Player;

abstract public class Facility extends Cell {

    public Facility(int X, int Y) {
        super(X, Y);
    }

    abstract public void use(Player P);

    public boolean getIsObjectExist() {
        return false;
    }

    public boolean getIsGrassExist() {
        return false;
    }

    public void setIsObjectExist(boolean object) {
    }

    public void setIsGrassExist(boolean grass) {
    }

    abstract public char displaySymbol();
}
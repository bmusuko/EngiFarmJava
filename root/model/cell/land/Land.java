package model.cell.land;

import model.cell.Cell;

abstract public class Land extends Cell {
    protected boolean isObjectExist;
    protected boolean isGrassExist;

    public Land(int X, int Y, boolean object, boolean grass) {
        super(X, Y);
        this.isGrassExist = grass;
        this.isObjectExist = object;
    }

    public boolean getIsObjectExist() {
        return this.isObjectExist;
    }

    public boolean getIsGrassExist() {
        return this.isGrassExist;
    }

    public void setIsObjectExist(boolean object) {
        this.isObjectExist = object;
    }

    public void setIsGrassExist(boolean grass) {
        this.isGrassExist = grass;
    }

    abstract public char displaySymbol();
}
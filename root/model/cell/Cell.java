package model.cell;

abstract public class Cell {
    protected int X;
    protected int Y;

    public Cell() {
        this.X = 0;
        this.Y = 0;
    }

    public Cell(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    // Getter
    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    // Setter
    // Kyknya ga perlu setter, masa posisi cell bisa pindah wkwkwk
    abstract public boolean getIsObjectExist();

    abstract public boolean getIsGrassExist();

    abstract public void setIsObjectExist(boolean object);

    abstract public void setIsGrassExist(boolean grass);

    // buat display bentuknya di layar kek gimana
    abstract public char displaySymbol();

}
package EngiFarmJava.src;

class Grassland extends Land {
    Grassland(int X, int Y){
        super(X, Y, false, false);
    }

    public char displaySymbol(){
        if (isGrassExist){
            return "*";
        }else{
            return "-";
        }
    }
}
package EngiFarmJava.src;

class Well extends Facility {
    Well(int X, int Y){
        super(X,Y);
    }

    void use(Player P){
        P.setWadahAir(10);
    }

    public char displaySymbol(){
        return "W";
    }
}
class Coop extends Land {
    Coop(int X, int Y){
        super(X, Y, false, false);
    }

    public char displaySymbol(){
        if (isGrassExist){
            return 'o';
        }else{
            return '#';
        }
    }
}
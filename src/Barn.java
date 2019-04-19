class Barn extends Land {
    Barn(int X, int Y){
        super(X, Y, false, false);
    }

    public char displaySymbol(){
        if (isGrassExist){
            return '@';
        }else{
            return 'x';
        }
    }
}
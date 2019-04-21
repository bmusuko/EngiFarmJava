/**
 * @Class Barn adalah turunan dari kelas land
 */
class Barn extends Land {
    Barn(int X, int Y, boolean object, boolean grass){
        super(X, Y, object, grass);
    }

    public char displaySymbol(){
        if (isGrassExist){
            return '@';
        }else{
            return 'x';
        }
    }
}
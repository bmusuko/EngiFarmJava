/**
 * @Class Well adalah turunan kelas Facility
 */
class Well extends Facility {
    Well(int X, int Y){
        super(X,Y);
    }

    void use(Player P){
        System.out.println("Wadah air anda sudah terisi penuh!");
        P.setWadahAir(10);
    }

    public char displaySymbol(){
        return 'W';
    }
}
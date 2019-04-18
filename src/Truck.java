// public class Truck implements Facility {
//     public Truck(int X, int Y) {

//     }

//     public void minCD() {

//     }

//     public void use(LinkedList<T> LP, int money, int water, String masukan) {

//     }

//     public boolean getIsGrassExist() {

//     }

//     public boolean getIsObjectExist() {

//     }
// }

class Truck extends Facility{
    private int cooldown;
    Truck(int X, int Y){
        super(X, Y);
        cooldown = 5;
    }

    public void minCD(){
        if (cooldown>0){
            this.cooldown--;
        }
    }

    //gatau bisa ap engga
    public void use(Player P){
        if (cooldown == 0){
            int hasil = 0;
            Product p;
            while (!P.getTas().isEmpty()){
                p = P.getTas().remove();
                hasil+=p.getHarga();
            }
            P.setMoney(P.getMoney()+hasil);
            cooldown = 5;
        }else{
            System.out.println("Truck belum siap!, silahkan menunggu "+cooldown+" tick lagi.");
        }
    }

    public char displaySymbol(){
        return "T";
    }
}
class PlayerTest{
    public static void main(String args[]){
        Player P = new Player(0,0);
        Truck T = new Truck(0,0);
        Well W = new Well(0,0);
        P.displayStatus();
        Barn B = new Barn(0,0);
        P.grow(B);
        P.displayStatus();
        P.interact(W);
        P.displayStatus();
        //interact ke facility sama grow udah di tes
    }
}
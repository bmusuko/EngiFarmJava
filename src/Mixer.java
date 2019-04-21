/**
 * @Class Mixer adalah turunan kelas Facility
 */
import java.util.Scanner;
import java.util.LinkedList;

public class Mixer extends Facility {
    private int pilihan;
    public Mixer(int x, int y) {
        super(x, y);
        pilihan = 0;
    }

    public void setPilihan(int pilihan){
        this.pilihan = pilihan;
    }

    public boolean isInventAvailable(LinkedList<Product> LP, Product P1, Product P2) {
        boolean foundP1 = false;
        boolean foundP2 = false;
        for (int i = 0; i < LP.size(); i++) {
            if (foundP1 && foundP2) {
                break;
            }
            if ((P1 instanceof ChickenEgg && P2 instanceof DuckEgg) && (LP.get(i) instanceof ChickenEgg) && !foundP1) {
                foundP1 = true;
                continue;
            } else if ((P1 instanceof ChickenEgg && P2 instanceof DuckEgg) && (LP.get(i) instanceof DuckEgg)
                    && !foundP2) {
                foundP2 = true;
                continue;
            }

            if ((P1 instanceof CowMilk && P2 instanceof GoatMilk) && (LP.get(i) instanceof CowMilk) && !foundP1) {
                foundP1 = true;
                continue;
            } else if ((P1 instanceof CowMilk && P2 instanceof GoatMilk) && LP.get(i) instanceof GoatMilk && !foundP2) {
                foundP2 = true;
                continue;
            }
            if ((P1 instanceof ChickenEgg && P2 instanceof CowMeat) && (LP.get(i) instanceof ChickenEgg) && !foundP1) {
                foundP1 = true;
                continue;
            } else if ((P1 instanceof ChickenEgg && P2 instanceof CowMeat) && (LP.get(i) instanceof CowMeat)
                    && !foundP2) {
                foundP2 = true;
                continue;
            } else {
                continue;
            }
        }
        return foundP1 && foundP2;

    }

    public LinkedList<Product> deleteNeededPoduct(LinkedList<Product> LP, Product P1, Product P2) {
        boolean foundP1 = true;
        boolean foundP2 = true;
        for (int i = 0; i < LP.size(); i++) {
            if (!foundP1 && !foundP2) {
                break;
            }
            if ((P1 instanceof ChickenEgg) && (LP.get(i) instanceof ChickenEgg) && foundP1) {
                foundP1 = false;
                LP.remove(LP.get(i));
            }
            if ((P2 instanceof DuckEgg) && (LP.get(i) instanceof DuckEgg) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            }
            if ((P1 instanceof CowMilk) && (LP.get(i) instanceof CowMilk) && foundP1) {
                foundP1 = false;
                LP.remove(LP.get(i));
            }
            if ((P2 instanceof GoatMilk) && (LP.get(i) instanceof GoatMilk) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            }
            if ((P2 instanceof CowMeat) && (LP.get(i) instanceof CowMeat) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            }
        }
        return LP;
    }

    public void createMartabak(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        DuckEgg D = new DuckEgg();
        Martabak MB = new Martabak();
        if (isInventAvailable(LP, C, D)) {
            LP = deleteNeededPoduct(LP, C, D);
            LP.add(MB);
            // return LP;
        }
    }

    public void createCheese(LinkedList<Product> LP) {
        CowMilk CM = new CowMilk();
        GoatMilk GM = new GoatMilk();
        Cheese C = new Cheese();
        if (isInventAvailable(LP, CM, GM)) {
            LP = deleteNeededPoduct(LP, CM, GM);
            LP.add(C);
            // return LP;
        }
    }

    public void createBeefRolade(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        CowMeat CM = new CowMeat();
        BeefRolade BM = new BeefRolade();
        if (isInventAvailable(LP, C, CM)) {
            LP = deleteNeededPoduct(LP, C, CM);
            LP.add(BM);

        }
    }

    public void use(Player P) {
        System.out.println("masuk use mixer!");
        if (pilihan == 1) {
            System.out.println("masuk martabak");
            createMartabak(P.getTas());
        } else if (pilihan == 2) {
            createCheese(P.getTas());
        } else if (pilihan == 3) {
            createBeefRolade(P.getTas());
        }
        this.pilihan = 0;
    }

    public boolean getIsGrassExist() {
        return false;
    }

    public boolean getIsObjectExist() {
        return false;
    }

    public char displaySymbol() {
        return 'M';
    }
}

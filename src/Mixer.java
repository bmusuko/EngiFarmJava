import java.util.Scanner;
import java.util.LinkedList;

public class Mixer extends Facility {
    public Mixer(int x, int y) {
        super(x, y);
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
            if (LP.get(i) == P1 && foundP1) {
                LP.remove(i);
                foundP1 = false;
                continue;
            }
            if (LP.get(i) == P2 && foundP2) {
                LP.remove(i);
                foundP2 = false;
                continue;
            }
        }
        return LP;
    }

    public LinkedList<Product> createMartabak(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        DuckEgg D = new DuckEgg();
        Martabak MB = new Martabak();
        if (isInventAvailable(LP, C, D)) {
            LP = deleteNeededPoduct(LP, C, D);
            LP.add(MB);
            return LP;
        } else {
            return LP;
        }
    }

    public LinkedList<Product> createCheese(LinkedList<Product> LP) {
        CowMilk CM = new CowMilk();
        GoatMilk GM = new GoatMilk();
        Cheese C = new Cheese();
        if (isInventAvailable(LP, CM, GM)) {
            LP = deleteNeededPoduct(LP, CM, GM);
            LP.add(C);
            return LP;
        } else {
            return LP;
        }
    }

    public LinkedList<Product> createBeefRolade(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        CowMilk CM = new CowMilk();
        BeefRolade BM = new BeefRolade();
        if (isInventAvailable(LP, C, CM)) {
            LP = deleteNeededPoduct(LP, C, CM);
            LP.add(BM);
            return LP;
        } else {
            return LP;
        }
    }

    public void use(Player P) {
        System.out.println("1. Martabak 2. Cheese 3. BeefRolade");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Product> p = P.getTas();
        if (n == 1) {
            p = createMartabak(P.getTas());
        }
        else if (n==2) {
            p = createCheese(P.getTas());
        }
        else if (n==3) {
            p = createBeefRolade(P.getTas());
        }
        sc.close();
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

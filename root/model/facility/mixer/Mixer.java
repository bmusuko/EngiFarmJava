package model.facility.mixer;

import model.facility.Facility;
import model.farmProduct.Product;
import model.farmProduct.beefRolade.BeefRolade;
import model.farmProduct.cheese.Cheese;
import model.farmProduct.martabak.Martabak;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import model.farmProduct.egg.duckEgg.DuckEgg;
import model.farmProduct.milk.cowMilk.CowMilk;
import model.farmProduct.milk.goatMilk.GoatMilk;
import model.farmProduct.meat.cowMeat.CowMeat;
import model.player.Player;
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
            } else if ((P1 instanceof ChickenEgg) && (LP.get(i) instanceof ChickenEgg) && foundP1) {
                foundP1 = false;
                LP.remove(LP.get(i));
            } else if ((P2 instanceof DuckEgg) && (LP.get(i) instanceof DuckEgg) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            } else if ((P1 instanceof CowMilk) && (LP.get(i) instanceof CowMilk) && foundP1) {
                foundP1 = false;
                LP.remove(LP.get(i));
            } else if ((P2 instanceof GoatMilk) && (LP.get(i) instanceof GoatMilk) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            } else if ((P2 instanceof CowMeat) && (LP.get(i) instanceof CowMeat) && foundP2) {
                foundP2 = false;
                LP.remove(LP.get(i));
            }
        }
        return LP;
    }

    public void createMartabak(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        DuckEgg D = new DuckEgg();
        if (isInventAvailable(LP, C, D)) {
            LP = deleteNeededPoduct(LP, C, D);
            LP.add(new Martabak());
            // return LP;
        }
    }

    public void createCheese(LinkedList<Product> LP) {
        CowMilk CM = new CowMilk();
        GoatMilk GM = new GoatMilk();
        if (isInventAvailable(LP, CM, GM)) {
            LP = deleteNeededPoduct(LP, CM, GM);
            LP.add(new Cheese());
            // return LP;
        }
    }

    public void createBeefRolade(LinkedList<Product> LP) {
        ChickenEgg C = new ChickenEgg();
        CowMeat CM = new CowMeat();
        if (isInventAvailable(LP, C, CM)) {
            LP = deleteNeededPoduct(LP, C, CM);
            LP.add(new BeefRolade());

        }
    }

    public void use(Player P) {
        System.out.println("1. Martabak 2. Cheese 3. BeefRolade");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            createMartabak(P.getTas());
        } else if (n == 2) {
            createCheese(P.getTas());
        } else if (n == 3) {
            createBeefRolade(P.getTas());
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

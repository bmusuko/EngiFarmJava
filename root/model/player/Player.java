package model.player;

import model.cell.Cell;
import model.cell.land.Land;
import model.facility.Facility;
import model.farmProduct.Product;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import java.util.LinkedList;
import java.util.ListIterator;

public class Player {
    private int posisiX;
    private int posisiY;
    private int wadahAir;
    private int money;
    private LinkedList<Product> tas;

    // Konstruktor
    public Player(int posisiX, int posisiY) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.wadahAir = 10;
        this.money = 0;
        this.tas = new LinkedList<Product>();
    }

    // Getter
    public int getWadahAir() {
        return this.wadahAir;
    }

    public Product getIsiTas(int idx) {
        return this.tas.get(idx);
    }

    public LinkedList<Product> getTas() {
        return this.tas;
    }

    public int getMoney() {
        return this.money;
    }

    public int getPosisiX() {
        return this.posisiX;
    }

    public int getPosisiY() {
        return this.posisiY;
    }

    // Setter
    public void move(int param) {
        // 1 naik, 2 turun, 3 kiri, 4 kanan
        switch (param) {
        case 1:
            this.posisiX--;
            break;
        case 3:
            this.posisiX++;
            break;
        case 4:
            this.posisiY--;
            break;
        case 2:
            this.posisiY++;
            break;
        }
    }

    public void setWadahAir(int wadahAir) {
        this.wadahAir = wadahAir;
    }

    public void addElTas(Product P) {
        this.tas.add(P);
    }

    public void delElTas(Product P) {
        this.tas.remove(P);
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // Additional method

    public void interact(MilkProducingFarmAnimal animal) {
        // masih bingung
        this.addElTas(animal.respondInteract());
    }

    public void interact(EggProducingFarmAnimal animal) {
        // masih bingung
        this.addElTas(animal.respondInteract());
    }

    public void interact(Facility F) {
        F.use(this);
        // Entah knp gua coba kalo pakenya begini jdi bisa pass by reference ._.
    }

    public void grow(Land L) {
        if (wadahAir > 0) {
            L.setIsGrassExist(true);
            wadahAir--;
        } else {
            System.out.println("Wadah air anda kosong!");
        }
    }

    public void displayStatus() {
        System.out.println("Wadah Air : " + this.wadahAir);
        System.out.println("Money : " + this.money);
        if (this.tas.isEmpty()) {
            System.out.println("Inventory Kosong");
        } else {
            ListIterator<Product> iter = tas.listIterator(0);
            System.out.println("Inventory : ");
            while (iter.hasNext()) {
                System.out.println(iter.next().getClass().getSimpleName());
            }
        }
    }
}
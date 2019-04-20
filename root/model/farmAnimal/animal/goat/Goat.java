package model.farmAnimal.animal.goat;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.goatMeat.GoatMeat;
import model.farmProduct.milk.goatMilk.GoatMilk;
import java.util.*;

public class Goat extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal {
	public Goat(int x, int y) {
		super(x, y, 10);
	}

	public GoatMilk respondInteract() {
		if (super.getHasilProduct()) {
			super.setHasilProduct(false);
			return (new GoatMilk());
		} else {
			return null;
		}
	}

	public GoatMeat respondKill() {
		return (new GoatMeat());
	}

	public void suara() {
		System.out.println("mbee mbee");
	}

}

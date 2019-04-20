package model.farmAnimal.animal.cow;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.cowMeat.CowMeat;
import model.farmProduct.milk.cowMilk.CowMilk;
import java.util.*;

public class Cow extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal {
	public Cow(int x, int y) {
		super(x, y, 15);
	}

	public Product respondInteract() {
		if (super.getHasilProduct()) {
			super.setHasilProduct(false);
			return (new CowMilk());
		} else {
			return null;
		}
	}

	public Product respondKill() {
		return (new CowMeat());
	}

	public void suara() {
		System.out.println("Moo Moo");
	}

}

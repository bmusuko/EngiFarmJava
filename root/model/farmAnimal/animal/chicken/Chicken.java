package model.farmAnimal.animal.chicken;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.chickenMeat.ChickenMeat;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import java.util.*;

public class Chicken extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal {
	public Chicken(int x, int y) {
		super(x, y, 5);
	}

	public ChickenEgg respondInteract() {
		if (super.getHasilProduct()) {
			super.setHasilProduct(false);
			return (new ChickenEgg());
		} else {
			return null;
		}
	}

	public Product respondKill() {
		return (new ChickenMeat());
	}

	public void suara() {
		System.out.println("Ptok Ptok Ptok");
	}
}

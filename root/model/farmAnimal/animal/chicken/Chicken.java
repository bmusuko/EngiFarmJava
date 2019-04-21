package model.farmAnimal.animal.chicken;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.chickenMeat.ChickenMeat;
import model.farmProduct.egg.chickenEgg.ChickenEgg;
import java.util.*;

public class Chicken extends FarmAnimal implements EggProducingFarmAnimal<ChickenEgg>, MeatProducingFarmAnimal<ChickenMeat> {
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

	public ChickenMeat respondKill() {
		return (new ChickenMeat());
	}

	public String suara() {
		return (new String("ptok ptok"));
	}
}

package model.farmAnimal.animal.chicken;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import java.util.*;

class Chicken extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal {
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

	public void suara() {
		System.out.println("Ptok Ptok Ptok");
	}

}

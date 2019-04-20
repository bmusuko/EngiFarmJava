package model.farmAnimal.animal.duck;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.eggProducingAnimal.EggProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import java.util.*;

class Duck extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal {
	public Duck(int x, int y) {
		super(x, y, 6);
	}

	public DuckEgg respondInteract() {
		if (super.getHasilProduct()) {
			super.setHasilProduct(false);
			return (new DuckEgg());
		} else {
			return null;
		}
	}

	public DuckMeat respondKill() {
		return (new DuckMeat());
	}

	public void suara() {
		System.out.println("Kwek Kwek Kwek");
	}

}

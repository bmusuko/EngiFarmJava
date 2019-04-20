package model.farmAnimal.animal.sheep;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import java.util.*;

class Sheep extends FarmAnimal implements MeatProducingFarmAnimal {
	public Sheep(int x, int y) {
		super(x, y, 12);
	}

	public SheepMeat respondKill() {
		return (new SheepMeat());
	}

	public void suara() {
		System.out.println("mbe be be");
	}

}

package model.farmAnimal.animal.sheep;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.sheepMeat.SheepMeat;
import java.util.*;

public class Sheep extends FarmAnimal implements MeatProducingFarmAnimal {
	public Sheep(int x, int y) {
		super(x, y, 12);
	}

	public SheepMeat respondKill() {
		return (new SheepMeat());
	}

	public String suara() {
		return (new String("mbe be be"));
	}

}

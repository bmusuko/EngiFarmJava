package model.farmAnimal.animal.buffalo;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.buffaloMeat.BuffaloMeat;
import java.util.*;

public class Buffalo extends FarmAnimal implements MeatProducingFarmAnimal<BuffaloMeat> {
	public Buffalo(int x, int y) {
		super(x, y, 14);
	}

	public BuffaloMeat respondKill() {
		return (new BuffaloMeat());
	}

	public String suara() {
		return (new String("Hoff Hoff"));
	}

}

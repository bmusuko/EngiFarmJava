package model.farmAnimal.animal.cow;

import model.farmAnimal.FarmAnimal;
import model.farmAnimal.milkProducingAnimal.MilkProducingFarmAnimal;
import model.farmAnimal.meatProducingAnimal.MeatProducingFarmAnimal;
import model.farmProduct.Product;
import model.farmProduct.meat.cowMeat.CowMeat;
import model.farmProduct.milk.cowMilk.CowMilk;
import java.util.*;

public class Cow extends FarmAnimal implements MilkProducingFarmAnimal<CowMilk>, MeatProducingFarmAnimal<CowMeat> {
	public Cow(int x, int y) {
		super(x, y, 15);
	}

	public CowMilk respondInteract() {
		if (super.getHasilProduct()) {
			super.setHasilProduct(false);
			return (new CowMilk());
		} else {
			return null;
		}
	}

	public CowMeat respondKill() {
		return (new CowMeat());
	}

	public String suara() {
		return (new String("moo moo"));
	}

}

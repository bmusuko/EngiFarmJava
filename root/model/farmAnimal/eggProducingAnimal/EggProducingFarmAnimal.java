package model.farmAnimal.eggProducingAnimal;

import model.farmProduct.Product;
import java.util.*;

public interface EggProducingFarmAnimal<T extends Product> {
	public T respondInteract();
}
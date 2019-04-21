package model.farmAnimal.milkProducingAnimal;

import model.farmProduct.Product;
import java.util.*;

public interface MilkProducingFarmAnimal<T extends Product> {
	public T respondInteract();
}
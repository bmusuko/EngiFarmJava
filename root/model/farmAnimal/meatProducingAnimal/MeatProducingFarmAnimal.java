package model.farmAnimal.meatProducingAnimal;

import model.farmProduct.Product;
//import model.farmProduct.meat.chickenMeat.ChickenMeat;

import java.util.*;

public interface MeatProducingFarmAnimal<T extends Product>  {
	public T respondKill();
}
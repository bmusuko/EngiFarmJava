import java.util.*;



class Chicken extends FarmAnimal implements EggProducingFarmAnimal<ChickenEgg>, MeatProducingFarmAnimal<ChickenMeat>{
	public Chicken(int x,int y){
		super(x,y,5);
	}

	public ChickenEgg respondInteract(){
		if(super.getHasilProduct){
			return (new ChickenEgg());
			super.setHasilProduct(false);
		}
	}

	public ChickenMeat respondKill(){
		return (new ChickenMeat());
	}

	public void suara(){
		System.out.println("Ptok Ptok Ptok");
	}


}

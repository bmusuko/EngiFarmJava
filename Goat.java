import java.util.*;

class Goat extends FarmAnimal implements EggProducingFarmAnimal<GoatMilk>, MeatProducingFarmAnimal<GoatMeat>{
	public Goat(int x,int y){
		super(x,y,10);
	}

	public GoatMilk respondInteract(){
		if(super.getHasilProduct){
			return (new GoatMilk());
			super.setHasilProduct(false);
		}
	}

	public GoatMeat respondKill(){
		return (new GoatMeat());
	}

	public void suara(){
		System.out.println("mbee mbee");
	}

	
}

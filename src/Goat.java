import java.util.*;

class Goat extends FarmAnimal implements MeatProducingFarmAnimal{
	public Goat(int x,int y){
		super(x,y,10);
	}

	public GoatMilk respondInteract(){
		if(super.getHasilProduct()){
			super.setHasilProduct(false);
			return (new GoatMilk());
		} else {
			return null;
		}
	}

	public GoatMeat respondKill(){
		return (new GoatMeat());
	}

	public void suara(){
		System.out.println("mbee mbee");
	}

	
}

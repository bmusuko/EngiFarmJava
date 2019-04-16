import java.util.*;



class Duck extends FarmAnimal implements EggProducingFarmAnimal<DuckEgg>, MeatProducingFarmAnimal<DuckMeat>{
	public Duck(int x,int y){
		super(x,y,6);
	}

	public DuckEgg respondInteract(){
		if(super.getHasilProduct()){
			super.setHasilProduct(false);
			return (new DuckEgg());
		} else {
			return null;
		}
	}

	public DuckMeat respondKill(){
		return (new DuckMeat());
	}

	public void suara(){
		System.out.println("Kwek Kwek Kwek");
	}


}

import java.util.*;



class Sheep extends FarmAnimal implements MilkProducingFarmAnimal<SheepMilk>, MeatProducingFarmAnimal<SheepMeat>{
	public Sheep(int x,int y){
		super(x,y,12);
	}

	public SheepMilk respondInteract(){
		if(super.getHasilProduct){
			return (new SheepMilk());
			super.setHasilProduct(false);
		}
	}

	public SheepMeat respondKill(){
		return (new SheepMeat());
	}

	public void suara(){
		System.out.println("mbe be be");
	}


}

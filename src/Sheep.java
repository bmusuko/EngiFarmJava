import java.util.*;



class Sheep extends FarmAnimal implements MeatProducingFarmAnimal<SheepMeat>{
	public Sheep(int x,int y){
		super(x,y,12);
	}

	public SheepMeat respondKill(){
		return (new SheepMeat());
	}

	public void suara(){
		System.out.println("mbe be be");
	}


}

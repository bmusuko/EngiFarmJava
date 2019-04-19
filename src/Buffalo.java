import java.util.*;

class Buffalo extends FarmAnimal implements MeatProducingFarmAnimal{
	public Buffalo(int x,int y){
		super(x,y,14);
	}

	public BuffaloMeat respondKill(){
		return (new BuffaloMeat());
	}

	public void suara(){
		System.out.println("Hoff Hoff");
	}

	
}

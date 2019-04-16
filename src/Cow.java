import java.util.*;



class Cow extends FarmAnimal implements MilkProducingFarmAnimal<CowMilk>, MeatProducingFarmAnimal<CowMeat>{
	public Chicken(int x,int y){
		super(x,y,15);
	}

	public CowMilk respondInteract(){
		if(super.getHasilProduct){
			return (new CowMilk());
			super.setHasilProduct(false);
		}
	}

	public CowMeat respondKill(){
		return (new CowMeat());
	}

	public void suara(){
		System.out.println("Moo Moo");
	}

}

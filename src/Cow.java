import java.util.*;



class Cow extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal{
	public Cow(int x,int y){
		super(x,y,15);
	}

	public CowMilk respondInteract(){
		if(super.getHasilProduct()){
			super.setHasilProduct(false);
			return (new CowMilk());			
		} else {
			return null;
		}
	}

	public CowMeat respondKill(){
		return (new CowMeat());
	}

	public void suara(){
		System.out.println("Moo Moo");
	}

}

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Cell.java \
        Land.java \
        Barn.java \
        Coop.java \
        Grassland.java \
        Facility.java \
        Mixer.java \
        Truck.java \
        Well.java \
        FarmAnimal.java \
        Buffalo.java \
        Chicken.java \
        Cow.java \
		Duck.java \
		Goat.java \
		Sheep.java \
		EggProducingFarmAnimal.java \
		MeatProducingFarmAnimal.java \
		MilkProducingFarmAnimal.java \
		Product.java \
		BeefRolade.java \
		Cheese.java \
		ChickenEgg.java \
		DuckEgg.java \
		Martabak.java \
		BuffaloMeat.java \
		ChickenMeat.java \
		CowMeat.java \
		DuckMeat.java \
		GoatMeat.java \
		SheepMeat.java \
		CowMilk.java \
		GoatMilk.java \
		Player.java \
		Game.java \
        GameMain.java
		
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
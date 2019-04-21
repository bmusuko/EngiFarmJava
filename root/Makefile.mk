JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        model/cell/Cell.java \
        model/cell/land/Land.java \
        model/cell/land/barn/Barn.java \
        model/cell/land/coop/Coop.java \
        model/cell/land/grassLand/Grassland.java \
        model/facility/Facility.java \
        model/facility/mixer/Mixer.java \
        model/facility/truck/Truck.java \
        model/facility/well/Well.java \
        model/farmAnimal/FarmAnimal.java \
        model/farmAnimal/animal/buffalo/Buffalo.java \
        model/farmAnimal/animal/chicken/Chicken.java \
        model/farmAnimal/animal/cow/Cow.java \
		model/farmAnimal/animal/duck/Duck.java \
		model/farmAnimal/animal/goat/Goat.java \
		model/farmAnimal/animal/sheep/Sheep.java \
		model/farmAnimal/eggProducingAnimal/EggProducingFarmAnimal.java \
		model/farmAnimal/meatProducingAnimal/MeatProducingFarmAnimal.java \
		model/farmAnimal/milkProducingAnimal/MilkProducingFarmAnimal.java \
		model/farmProduct/Product.java \
		model/farmProduct/beefRolade/BeefRolade.java \
		model/farmProduct/cheese/Cheese.java \
		model/farmProduct/egg/chickenEgg/ChickenEgg.java \
		model/farmProduct/egg/duckEgg/DuckEgg.java \
		model/farmProduct/martabak/Martabak.java \
		model/farmProduct/meat/buffaloMeat/BuffaloMeat.java \
		model/farmProduct/meat/chickenMeat/ChickenMeat.java \
		model/farmProduct/meat/cowMeat/CowMeat.java \
		model/farmProduct/meat/duckMeat/DuckMeat.java \
		model/farmProduct/meat/goatMeat/GoatMeat.java \
		model/farmProduct/meat/sheepMeat/SheepMeat.java \
		model/farmProduct/milk/cowMilk/CowMilk.java \
		model/farmProduct/milk/goatMilk/GoatMilk.java \
		model/player/Player.java \
		control/Game.java \
        view/GameMain.java
		
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
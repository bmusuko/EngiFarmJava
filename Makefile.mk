JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        root/model/cell/Cell.java \
        root/model/cell/land/Land.java \
        root/model/cell/land/barn/Barn.java \
        root/model/cell/land/coop/Coop.java \
        root/model/cell/land/grassLand/Grassland.java \
        root/model/facility/Facility.java \
        root/model/facility/mixer/Mixer.java \
        root/model/facility/truck/Truck.java \
        root/model/facility/well/Well.java \
        root/model/farmAnimal/FarmAnimal.java \
        root/model/farmAnimal/animal/buffalo/Buffalo.java \
        root/model/farmAnimal/animal/chicken/Chicken.java \
        root/model/farmAnimal/animal/cow/Cow.java \
		root/model/farmAnimal/animal/duck/Duck.java \
		root/model/farmAnimal/animal/goat/Goat.java \
		root/model/farmAnimal/animal/sheep/Sheep.java \
		root/model/farmAnimal/eggProducingAnimal/EggProducingFarmAnimal.java \
		root/model/farmAnimal/meatProducingAnimal/MeatProducingFarmAnimal.java \
		root/model/farmAnimal/milkProducingAnimal/MilkProducingFarmAnimal.java \
		root/model/farmProduct/Product.java \
		root/model/farmProduct/beefRolade/BeefRolade.java \
		root/model/farmProduct/cheese/Cheese.java \
		root/model/farmProduct/egg/chickenEgg/ChickenEgg.java \
		root/model/farmProduct/egg/duckEgg/DuckEgg.java \
		root/model/farmProduct/martabak/Martabak.java \
		root/model/farmProduct/meat/buffaloMeat/BuffaloMeat.java \
		root/model/farmProduct/meat/chickenMeat/ChickenMeat.java \
		root/model/farmProduct/meat/cowMeat/CowMeat.java \
		root/model/farmProduct/meat/duckMeat/DuckMeat.java \
		root/model/farmProduct/meat/goatMeat/GoatMeat.java \
		root/model/farmProduct/meat/sheepMeat/SheepMeat.java \
		root/model/farmProduct/milk/cowMilk/CowMilk.java \
		root/model/farmProduct/milk/goatMilk/GoatMilk.java \
		root/model/player/Player.java \
		root/control/Game.java \
        root/view/GameMain.java
		
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
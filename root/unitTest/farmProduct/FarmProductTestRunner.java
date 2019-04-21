package unitTest.farmProduct;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FarmProductTestRunner {
    public static void main(String[] args) {
        Result resultBeefRolade = JUnitCore.runClasses(BeefRoladeTest.class);
        for (Failure failure : resultBeefRolade.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultBeefRolade.wasSuccessful());
        System.out.println();

        Result resultBuffaloMeat = JUnitCore.runClasses(BuffaloMeatTest.class);
        for (Failure failure : resultBuffaloMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultBuffaloMeat.wasSuccessful());
        System.out.println();

        Result resultCheese = JUnitCore.runClasses(CheeseTest.class);
        for (Failure failure : resultCheese.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCheese.wasSuccessful());
        System.out.println();

        Result resultChickenEgg = JUnitCore.runClasses(ChickenEggTest.class);
        for (Failure failure : resultChickenEgg.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultChickenEgg.wasSuccessful());
        System.out.println();

        Result resultChickenMeat = JUnitCore.runClasses(ChickenMeatTest.class);
        for (Failure failure : resultChickenMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultChickenMeat.wasSuccessful());
        System.out.println();

        Result resultCowMeat = JUnitCore.runClasses(CowMeatTest.class);
        for (Failure failure : resultCowMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCowMeat.wasSuccessful());
        System.out.println();

        Result resultCowMilk = JUnitCore.runClasses(CowMilkTest.class);
        for (Failure failure : resultCowMilk.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCowMilk.wasSuccessful());
        System.out.println();

        Result resultDuckEgg = JUnitCore.runClasses(DuckEggTest.class);
        for (Failure failure : resultDuckEgg.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultDuckEgg.wasSuccessful());
        System.out.println();

        Result resultDuckMeat = JUnitCore.runClasses(DuckMeatTest.class);
        for (Failure failure : resultDuckMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultDuckMeat.wasSuccessful());
        System.out.println();

        Result resultGoatMeat = JUnitCore.runClasses(GoatMeatTest.class);
        for (Failure failure : resultGoatMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultGoatMeat.wasSuccessful());
        System.out.println();

        Result resultGoatMilk = JUnitCore.runClasses(GoatMilkTest.class);
        for (Failure failure : resultGoatMilk.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultGoatMilk.wasSuccessful());
        System.out.println();

        Result resultMartabak = JUnitCore.runClasses(MartabakTest.class);
        for (Failure failure : resultMartabak.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultMartabak.wasSuccessful());
        System.out.println();

        Result resultSheepMeat = JUnitCore.runClasses(SheepMeatTest.class);
        for (Failure failure : resultSheepMeat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultSheepMeat.wasSuccessful());
        System.out.println();

    }
}
package unitTest.farmAnimal;

import unitTest.farmAnimal.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FarmAnimalTestRunner {
    public static void main(String[] args) {
        Result resultBuffalo = JUnitCore.runClasses(BuffaloTest.class);
        for (Failure failure : resultBuffalo.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultBuffalo.wasSuccessful());
        System.out.println();

        Result resultChicken = JUnitCore.runClasses(ChickenTest.class);
        for (Failure failure : resultChicken.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultChicken.wasSuccessful());
        System.out.println();

        Result resultCow = JUnitCore.runClasses(CowTest.class);
        for (Failure failure : resultCow.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCow.wasSuccessful());
        System.out.println();

        Result resultDuck = JUnitCore.runClasses(DuckTest.class);
        for (Failure failure : resultDuck.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultDuck.wasSuccessful());
        System.out.println();

        Result resultGoat = JUnitCore.runClasses(GoatTest.class);
        for (Failure failure : resultGoat.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultGoat.wasSuccessful());
        System.out.println();

        Result resultSheep = JUnitCore.runClasses(SheepTest.class);
        for (Failure failure : resultSheep.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultSheep.wasSuccessful());
        System.out.println();
    }
}
package unitTest.cell;

import unitTest.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CellTestRunner {
    public static void main(String[] args) {
        Result resultGrassland = JUnitCore.runClasses(GrasslandTest.class);
        for (Failure failure : resultGrassland.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultGrassland.wasSuccessful());
        System.out.println();

        Result resultCoop = JUnitCore.runClasses(CoopTest.class);
        for (Failure failure : resultCoop.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCoop.wasSuccessful());
        System.out.println();

        Result resultBarn = JUnitCore.runClasses(BarnTest.class);
        for (Failure failure : resultBarn.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultBarn.wasSuccessful());
        System.out.println();

        Result resultLand = JUnitCore.runClasses(LandTest.class);
        for (Failure failure : resultLand.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultLand.wasSuccessful());
        System.out.println();

        Result resultCell = JUnitCore.runClasses(CellTest.class);
        for (Failure failure : resultCell.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultCell.wasSuccessful());
        System.out.println();
    }
}
package unitTest.facility;

import unitTest.*;
import unitTest.facility.TruckTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FacilityTestRunner {
    public static void main(String[] args) {
        Result resultMixer = JUnitCore.runClasses(MixerTest.class);
        for (Failure failure : resultMixer.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultMixer.wasSuccessful());
        System.out.println();

        Result resultTruck = JUnitCore.runClasses(TruckTest.class);
        for (Failure failure : resultTruck.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultTruck.wasSuccessful());
        System.out.println();

        Result resultWell = JUnitCore.runClasses(WellTest.class);
        for (Failure failure : resultWell.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultWell.wasSuccessful());
        System.out.println();
    }
}
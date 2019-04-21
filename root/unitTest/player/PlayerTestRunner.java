package unitTest.player;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PlayerTestRunner {
    public static void main(String[] args) {
        Result resultPlayer = JUnitCore.runClasses(PlayerTest.class);
        for (Failure failure : resultPlayer.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultPlayer.wasSuccessful());
        System.out.println();
    }
}
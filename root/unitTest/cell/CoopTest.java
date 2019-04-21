package unitTest.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.coop.Coop;

public class CoopTest {
    public Coop Cp1 = new Coop(0, 0, true, false);
    public Coop Cp2 = new Coop(0, 1, false, true);

    @Test
    public void displayExistGrassTest() {
        System.out.println("Coop display grass exist");
        assertEquals(Cp2.displaySymbol(), '#');
    }

    @Test
    public void displayNotExistGrassTest() {
        System.out.println("Coop display grass not exist");
        assertEquals(Cp1.displaySymbol(), 'o');
    }
}
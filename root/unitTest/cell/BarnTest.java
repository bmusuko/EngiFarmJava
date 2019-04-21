package unitTest.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.barn.Barn;

public class BarnTest {
    public Barn Bn1 = new Barn(0, 0, true, false);
    public Barn Bn2 = new Barn(0, 1, false, true);

    @Test
    public void displayExistGrassTest() {
        System.out.println("Barn display grass exist");
        assertEquals(Bn2.displaySymbol(), '@');
    }

    @Test
    public void displayNotExistGrassTest() {
        System.out.println("Barn display grass not exist");
        assertEquals(Bn1.displaySymbol(), 'x');
    }
}
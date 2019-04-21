package unitTest.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.grassLand.Grassland;

public class GrasslandTest {
    public Grassland Gl1 = new Grassland(0, 0, true, false);
    public Grassland Gl2 = new Grassland(0, 1, false, true);

    @Test
    public void displayExistGrassTest() {
        System.out.println("Grassland display grass exist");
        assertEquals(Gl2.displaySymbol(), '*');
    }

    @Test
    public void displayNotExistGrassTest() {
        System.out.println("Grassland display grass not exist");
        assertEquals(Gl1.displaySymbol(), '-');
    }
}
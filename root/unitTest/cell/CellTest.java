package unitTest.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.barn.Barn;
import model.cell.land.coop.Coop;
import model.cell.land.grassLand.Grassland;

public class CellTest {
    public Barn Bn1 = new Barn(0, 0, false, false);
    public Barn Bn2 = new Barn(0, 1, false, true);
    public Coop Cp1 = new Coop(1, 0, false, false);
    public Coop Cp2 = new Coop(1, 1, true, true);
    public Grassland Gl1 = new Grassland(2, 0, true, false);
    public Grassland Gl2 = new Grassland(2, 1, false, true);

    @Test
    public void getXTest() {
        System.out.println("Cell getXTest");
        assertEquals(Bn1.getX(), 0);
        assertEquals(Cp2.getX(), 1);
        assertEquals(Gl1.getX(), 2);
    }

    @Test
    public void getYTest() {
        System.out.println("Cell getYTest");
        assertEquals(Bn2.getY(), 1);
        assertEquals(Cp1.getY(), 0);
        assertEquals(Gl2.getY(), 1);
    }

}

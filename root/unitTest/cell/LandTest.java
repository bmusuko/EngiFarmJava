package unitTest.cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.cell.Cell;
import model.cell.land.Land;
import model.cell.land.barn.Barn;
import model.cell.land.coop.Coop;
import model.cell.land.grassLand.Grassland;

public class LandTest {
    public Barn Bn1 = new Barn(0, 0, false, false);
    public Barn Bn2 = new Barn(0, 1, false, true);
    public Coop Cp1 = new Coop(1, 0, false, false);
    public Coop Cp2 = new Coop(1, 1, true, true);
    public Grassland Gl1 = new Grassland(2, 0, true, false);
    public Grassland Gl2 = new Grassland(2, 1, false, true);

    @Test
    public void isObjectExistTest() {
        System.out.println("Land getisObjectExist method test");
        assertEquals(Bn1.getIsObjectExist(), false);
        assertEquals(Cp2.getIsObjectExist(), true);
        assertEquals(Gl1.getIsObjectExist(), true);
    }

    @Test
    public void isGrassExistTest() {
        System.out.println("Land getisGrassExist method test");
        assertEquals(Bn2.getIsGrassExist(), true);
        assertEquals(Cp1.getIsGrassExist(), false);
        assertEquals(Gl2.getIsGrassExist(), true);
    }
}
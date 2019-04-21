package unitTest.facility;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import model.facility.Facility;
import model.facility.well.Well;
import model.player.Player;
import model.cell.land.Land;
import model.cell.land.barn.Barn;

public class WellTest {
    public Well W = new Well(0, 0);
    public Player P = new Player(0, 1);
    public Barn B = new Barn(0, 1, false, false);

    @Test
    public void useTest() {
        System.out.println("Well use Test");
        P.grow(B);
        P.grow(B);
        P.grow(B);
        assertEquals(P.getWadahAir(), 7);
        W.use(P);
        assertEquals(P.getWadahAir(), 10);
    }
}
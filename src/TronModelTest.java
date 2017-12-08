import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TronModelTest {

    TronModel model;
    public final int NORTH = 0;
    public final int EAST = 1;
    public final int SOUTH = 2;
    public final int WEST = 3;

    @Before
    public void init(){
        model = new TronModel(5);
    }

    @Test
    public void areXYRowsColumnsNotBackwardsTest() throws Exception{
        int[] expectedBoard = new int[5];
        //assertEquals(expectedBoard, model.getBoard());
        Location p1startingLocation = new Location(5/2, 1);
        Location p2startingLocation = new Location(5/2, 4);
        assertEquals(p1startingLocation.getY(), model.getPlayer1().getY());
        assertEquals(p1startingLocation.getX(), model.getPlayer1().getX());
        assertEquals(p2startingLocation.getY(), model.getPlayer2().getY());
        assertEquals(p2startingLocation.getX(), model.getPlayer2().getX());
    }

    @Test
    public void constructorTest() throws Exception{
        int[] expectedBoard = new int[5];
        Player expectedP1 = new Player(StdDraw.YELLOW, 5/2, 1, EAST);
        Player expectedP2 = new Player(StdDraw.BLUE, 5/2, 4, WEST);
        assertEquals(expectedP1.getX(), model.getPlayer1().getX());
        assertEquals(expectedP1.getY(), model.getPlayer1().getY());
        assertEquals(expectedP2.getX(), model.getPlayer2().getX());
        assertEquals(expectedP2.getY(), model.getPlayer2().getY());
        assertEquals(expectedP1.getColor(), model.getPlayer1().getColor());
        assertEquals(expectedP2.getColor(), model.getPlayer2().getColor());
        assertEquals(expectedP1.getDirection(), model.getPlayer1().getDirection());
        assertEquals(expectedP2.getDirection(), model.getPlayer2().getDirection());
    }

    public void movePlayersTest() throws Exception{

    }

}
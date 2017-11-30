import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;

	@Before
	public void init(){
		player = new Player(Color.blue, 0, 0);
	}
	
	@Test
	public void storesCoords(){
		player.setX(3);
		player.setY(4);
		assertEquals(player.getX(), 3);
		assertEquals(player.getY(), 4);
	}
	
	@Test
	public void doesNotStoreNegative(){
		player.setX(-2);
		assertEquals(player.getX(), 0);
	}
	
	@Test
	public void storesColor(){
		player.setColor(Color.black);
		assertEquals(player.getColor(), Color.black);
		
	}
}


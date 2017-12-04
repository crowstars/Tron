import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	Location locate;
	
	@Before
	public void init(){
		locate = new Location(4, 4);
	}

	@Test
	public void testStorage() {
		assertEquals(locate.getColumn(), 4);
		locate = new Location(6, 3);
		assertEquals(locate.getColumn(), 3);
	}

}

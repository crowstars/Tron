import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class TronModelTest {
	
	TronModel board;
	
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

@ Before
public void init(){
	board = new TronModel(5);
	}

@Test
public void ifisEmpty(){
	
	board.player1move(SOUTH);
	board.player2move(NORTH);
	board.movePlayers();
	assertTrue(board.isEmpty(2,2));
	assertFalse(board.isEmpty(2, 0));
	assertTrue(board.isEmpty(1,2));
	assertFalse(board.isEmpty(2, 1));
	
}
@Test
public void getboard() {
	Color[][] board = new Color[5][5];
	board.player1move(SOUTH);
	board.updateBoard();
	assertEquals(board.getBoard(),board[2][1]);
}


}



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class TronModelTest {
	
	TronModel model;
	
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

@ Before
public void init(){
	model = new TronModel(5);
	}

@Test
public void ifisEmpty(){
	
	model.player1move(SOUTH);
	model.movePlayers();
	model.player2move(NORTH);
	model.movePlayers();
	model.updateBoard();
	assertTrue(model.isEmpty(2,2));
	assertFalse(model.isEmpty(2, 0));
	assertTrue(model.isEmpty(1,2));
	assertFalse(model.isEmpty(2, 1));
	assertFalse(model.isEmpty(2, 4));
	
}
@Test
public void getboard() {
	Color [][] board = new Color[5][5];
	model.player1move(SOUTH);
	model.movePlayers();
	model.updateBoard();
	assertEquals(model.getBoard(),board[2][1]);
}

public void getwinner() {
	Color [][] board = new Color[5][5];
	model.player1move(SOUTH);
	model.player1move(SOUTH);
	model.player1move(WEST);
	model.movePlayers();
	model.updateBoard();
	model.player2move(NORTH);
	model.player2move(NORTH);
	model.player2move(NORTH);
	assertEquals(model.getWinner(),player1);
	
}
}



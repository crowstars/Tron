import java.awt.Color;

public class TronModel {
	private Color[][] board;

	private Player player1;
	private Player player2;

	boolean gameOver;

	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

	public TronModel(int width){
		board = new Color[width][width];
		int midpoint = width/2;
		player1 = new Player(Color.YELLOW, midpoint, 0, SOUTH);
		player2 = new Player(Color.BLUE, midpoint, width-1, NORTH);
		updateBoard();
		gameOver = false;
	}

	public void updateBoard(){
		board[player1.getX()][player1.getY()] = player1.getColor();
		board[player2.getX()][player2.getY()] = player2.getColor();
	}

	//board accessors
	public Color[][] getBoard() {
		return board;
	}

	public boolean isEmpty(int x, int y){
		if(board[x][y] == null){
			return true;
		}
		else return false;
	}
	
	//keep returning null if nobody has won yet, otherwise return player that has won
	public Color getWinner(){
		//check if player 1 ran into wall
		if(player1.getX() == 0 || player1.getY() == 0) return Color.BLUE;
		
		//check if player 2 ran into wall 
		if(player2.getX() == 0 || player2.getY() == 0) return Color.YELLOW;
		
		//check if player 1 ran into trail 
		if(!isEmpty(player1.getX(), player1.getY())) return Color.BLUE;
		
		//check if player 2 ran into trail
		if(!isEmpty(player2.getX(), player2.getX())) return Color.YELLOW;
		
		return null;
	}

	public Player getPlayer1(){
		return player1;
	}
	
	public Player getPlayer2(){
		return player2;
	}

	public void movePlayers(){
		//Find destinations
		Location destination1;
		Location destination2;
		
		int direction = player1.getDirection();
		if(direction == NORTH){
			destination1 = new Location(player1.getX(), player1.getY() - 1);
		}
		else if(direction == EAST){
			destination1 = new Location(player1.getX() + 1, player1.getY());
		}
		else if (direction == SOUTH){
			destination1 = new Location(player1.getX(), player1.getY() + 1);
		}
		else{
			destination1 = new Location(player1.getX() - 1, player1.getY());
		}
		
		direction = player2.getDirection();
		if(direction == NORTH){
			destination2 = new Location(player2.getX(), player2.getY() - 1);
		}
		else if(direction == EAST){
			destination2 = new Location(player2.getX() + 1, player2.getY());
		}
		else if (direction == SOUTH){
			destination2 = new Location(player2.getX(), player2.getY() + 1);
		}
		else{
			destination2 = new Location(player2.getX() - 1, player2.getY());
		}
		
		//TODO finish this
		player1.setX(destination1.getColumn());
		player1.setY(destination1.getRow());
		
		player2.setX(destination2.getColumn());
		player2.setY(destination2.getRow());
		
	}
}

import java.awt.Color;

public class TronModel {
	private Color[][] board;

	private Player player1;
	private Player player2;
	private Color winner;

	boolean gameOver;

	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

	public TronModel(int width){
		board = new Color[width][width];
		int midpoint = width/2;
		player1 = new Player(Color.YELLOW, midpoint, 0, SOUTH);
		player2 = new Player(Color.BLUE, midpoint, width, NORTH);
		updateBoard();
		gameOver = false;
		winner = null;
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

	public Color getWinner(){
		return winner;
	}

	public void player1move(int direction){
		player1.setDirection(direction);
	}

	public void player2move(int direction){
		player2.setDirection(direction);
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
	}
}

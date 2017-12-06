import java.awt.Color;
//the problem is here
public class TronModel {
	private Color[][] board;

	private Player player1;
	private Player player2;

	boolean gameOver;
	Color winner;

	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;
	
	//Creates the board and sets the starting position for the players
	public TronModel(int width){
		board = new Color[width][width];
		int midpoint = width/2;
		player1 = new Player(StdDraw.YELLOW, 1, midpoint, EAST);
		player2 = new Player(StdDraw.BLUE, width -1, midpoint, WEST);
		//updateBoard();
		gameOver = false;
		winner = null;
	}

	public void updateBoard(){
		board[player1.getX()][player1.getY()] = player1.getColor();
		board[player2.getX()][player2.getY()] = player2.getColor();
	}

	//getter for board
	public Color[][] getBoard() {
		return board;
	}

	//checks to see if location is empty 
	public boolean isEmpty(int x, int y){
		if(board[x][y] == null){
			return true;
		}
		else return false;
	}

	//checks to see if game is over
	public boolean isGameOver() {
		return gameOver;
	}

	//keep returning null if nobody has won yet, otherwise return player that has won
	public Color getWinner(){
		return winner;
	}

	public Player getPlayer1(){
		return player1;
	}
	
	public Player getPlayer2(){
		return player2;
	}

	public void setPlayer1Direction(int direction){
		int currentDirection = player1.getDirection();
		if(!((currentDirection == NORTH && direction == SOUTH) || (currentDirection == SOUTH && direction == NORTH)
				|| (currentDirection == EAST && direction == WEST) || (currentDirection == WEST && direction == EAST))){
		player1.setDirection(direction);
		}
	}

	public void setPlayer2Direction(int direction){
		int currentDirection = player1.getDirection();
		if(!((currentDirection == NORTH && direction == SOUTH) || (currentDirection == SOUTH && direction == NORTH)
				|| (currentDirection == EAST && direction == WEST) || (currentDirection == WEST && direction == EAST))){
			player2.setDirection(direction);
		}
	}

	public void movePlayers(){
		//Find destinations
		Location destination1;
		Location destination2;

		int direction = player1.getDirection();
		if(direction == WEST){
			destination1 = new Location(player1.getX() - 1, player1.getY());
		}
		else if(direction == NORTH){
			destination1 = new Location(player1.getX(), player1.getY() + 1);
		}
		else if (direction == EAST){
			destination1 = new Location(player1.getX() + 1, player1.getY());
		}
		//Direction is south
		else{
			destination1 = new Location(player1.getX(), player1.getY() - 1);
		}

		direction = player2.getDirection();
		if(direction == WEST){
			destination2 = new Location(player2.getX() - 1, player2.getY());
		}
		else if(direction == NORTH){
			destination2 = new Location(player2.getX(), player2.getY() + 1);
		}
		else if (direction == EAST){
			destination2 = new Location(player2.getX() + 1, player2.getY());
		}
		//Direction is south
		else{
			destination2 = new Location(player2.getX(), player2.getY() - 1);
		}

		//Tests for collisions
		if(destination1.getRow() >= board.length || destination1.getColumn() >= board.length || destination1.getRow() <= 0 || destination1.getColumn() <= 0){
			gameOver = true;
			winner = player2.getColor();
			System.out.println("Player 1 ran into wall at " + destination1);
		}
		else if(destination2.getRow() >= board.length || destination2.getColumn() >= board.length || destination2.getRow() <= 0 || destination2.getColumn() <= 0){
			gameOver = true;
			winner = player1.getColor();
			System.out.println("Player 2 ran into wall at " + destination2);
		}
		else if(board[destination1.getRow()][destination1.getColumn()] != null){
			gameOver = true;
			winner = player2.getColor();
			System.out.println("Player 1 ran into light trail at " + destination1);
		}
		else if(board[destination2.getRow()][destination2.getColumn()] != null){
			gameOver = true;
			winner = player1.getColor();
			System.out.println("Player 2 ran into light trail at " + destination2);
		}


		if(!gameOver) {
			player1.setX(destination1.getRow());
			player1.setY(destination1.getColumn());

			player2.setX(destination2.getRow());
			player2.setY(destination2.getColumn());

			System.out.println("Player 1 at (" + destination1 + ")");
			System.out.println("Player 2 at (" + destination2 + ")");

			updateBoard();
		}
	}

	public Color getWinnerColor(){
		return winner;
	}
}

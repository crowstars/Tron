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

	//TODO rewrite starting positions
	public TronModel(int width){
		board = new Color[width][width];
		int midpoint = width/2;
		player1 = new Player(StdDraw.YELLOW, midpoint, width - 1, SOUTH);
		player2 = new Player(StdDraw.BLUE, midpoint, 1, NORTH);
		//updateBoard();
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

	public boolean isGameOver() {
		return gameOver;
	}

	//keep returning null if nobody has won yet, otherwise return player that has won
	public Color getWinner(){
		//check if player 1 ran into wall
		if(player1.getX() == 0 || player1.getY() == 0 || player1.getX() == 19 || player1.getY() == 19){
			System.out.println("wall");
			return player2.getColor();
		}
		
		//check if player 2 ran into wall 
		if(player2.getX() == 0 || player2.getY() == 0 || player2.getX() == 19 || player2.getY() == 19){
			System.out.println("wall");
			return player1.getColor();
		}
		
		//commented out for the time being until everything else is settled 
		//check if player 1 ran into trail 
//		if(!isEmpty(player1.getX(), player1.getY())){
//			return player2.getColor();
//		}
		
//		//check if player 2 ran into trail
//		if(!isEmpty(player2.getX(), player2.getX())){
//			return player1.getColor();
//		}
		
		return null;
	}

	public Player getPlayer1(){
		return player1;
	}
	
	public Player getPlayer2(){
		return player2;
	}

	public void setPlayer1Direction(int direction){
		player1.setDirection(direction);
	}

	public void setPlayer2Direction(int direction){
		player2.setDirection(direction);
	}

	public void movePlayers(){
		//Find destinations
		Location destination1;
		Location destination2;

		int direction = player1.getDirection();
		if(direction == NORTH){
			destination1 = new Location(player1.getX(), player1.getY() + 1);
		}
		else if(direction == EAST){
			destination1 = new Location(player1.getX() + 1, player1.getY());
		}
		else if (direction == SOUTH){
			destination1 = new Location(player1.getX(), player1.getY() - 1);
		}
		else{
			destination1 = new Location(player1.getX() - 1, player1.getY());
		}

		direction = player2.getDirection();
		if(direction == NORTH){
			destination2 = new Location(player2.getX(), player2.getY() + 1);
		}
		else if(direction == EAST){
			destination2 = new Location(player2.getX() + 1, player2.getY());
		}
		else if (direction == SOUTH){
			destination2 = new Location(player2.getX(), player2.getY() - 1);
		}
		else{
			destination2 = new Location(player2.getX() - 1, player2.getY());
		}

		//Test for collisions
		if(destination1.getRow() >= board.length || destination1.getColumn() >= board.length || destination1.getRow() <= 0 || destination1.getColumn() <= 0){
			gameOver = true;
			winner = player2.getColor();
			System.out.println("Player 1 ran into wall");
		}
		else if(destination2.getRow() >= board.length || destination2.getColumn() >= board.length || destination2.getRow() <= 0 || destination2.getColumn() <= 0){
			gameOver = true;
			winner = player1.getColor();
			System.out.println("Player 2 ran into wall");
		}
		else if(board[destination1.getRow()][destination1.getColumn()] != null){
			gameOver = true;
			winner = player2.getColor();
			System.out.println("Player 1 ran into light trail");
		}
		else if(board[destination2.getRow()][destination2.getColumn()] != null){
			gameOver = true;
			winner = player1.getColor();
			System.out.println("Player 2 ran into light trail");
		}
		
		System.out.println(destination1.getColumn());
		System.out.println(destination1.getRow());

		if(!gameOver) {
			player1.setX(destination1.getRow());
			player1.setY(destination1.getColumn());

			player2.setX(destination2.getRow());
			player2.setY(destination2.getColumn());

			updateBoard();
		}
	}

	public Color getWinnerColor(){
		return winner;
	}
	
	/*public void movePlayers(){
		int player1x = player1.getX();
		int player1y = player1.getY();
		int direction = player1.getDirection();
		switch(direction){
		case(NORTH):
			player1y -= 1;
			break;
		case(EAST):
			player1x += 1;
			break;
		case(SOUTH):
			player1y += 1;
			break;
		case(WEST):
			player1x -= 1;
			break;
		
		}
		
		int player2x = player2.getX();
		int player2y = player2.getY();
	    direction = player2.getDirection();
		switch(direction){
		case(NORTH):
			player2y -= 1;
			break;
		case(EAST):
			player2x += 1;
			break;
		case(SOUTH):
			player2y += 1;
			break;
		case(WEST):
			player2x -= 1;
			break;
		
		}	
		
		player1.setX(player1x);
		player1.setY(player1y);
		player2.setX(player2x);
		player2.setY(player2y);
		
		updateBoard();
	}*/
}

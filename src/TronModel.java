import java.awt.Color;

public class TronModel {
	private Color[][] board;

	private Player player1;
	private Player player2;

	public TronModel(int width){
		board = new Color[width][width];
		int midpoint = width/2;
		player1 = new Player(StdDraw.YELLOW, midpoint, 0);
		player2 = new Player(StdDraw.BLUE, midpoint, width);
		updateBoard();
	}

	public void updateBoard(){
		board[player1.getX()][player1.getY()] = player1.getColor();
		board[player2.getX()][player2.getY()] = player2.getColor();
	}
}

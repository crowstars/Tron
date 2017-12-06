import java.awt.Color;
import java.util.Arrays;

public class Tron {
	public final static Color player1Color = StdDraw.BLUE;
	public final Color player2Color = StdDraw.YELLOW;

	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

	public TronModel model;

	public final int SPEED = 30; // speed of game clock.
	public final int BOARD_SIZE = 40; // size of board

	public static void main(String args[]) {
		new Tron().runGame();
	}

	public void drawBasic() {
		// Color window
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);

		// add borders around windows
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.10, 0.445, 0.085);
		StdDraw.filledRectangle(0.5, 0.56, 0.355, 0.355);

		// draw windows
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
		StdDraw.filledRectangle(0.5, 0.56, 0.35, 0.35);

		// set title text
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.95, "Tron!");

		// draw tutorial text
		StdDraw.text(0.25, 0.15, "Player 1");
		StdDraw.text(0.25, 0.1, "Steer with WASD");

		StdDraw.text(0.75, 0.15, "Player 2");
		StdDraw.text(0.75, 0.1, "Steer with IJKL");

		StdDraw.text(0.5, 0.05, "Press SPACE to start");
	}

	public void handleKeyPresses() {
		// Copied from the Learn Java in N Games program AsteroidRally

		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_A)) {
			model.setPlayer1Direction(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_D)) {
			model.setPlayer1Direction(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_W)) {
			model.setPlayer1Direction(NORTH);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_S)) {
			model.setPlayer1Direction(SOUTH);
		}

		// scan inputs for player 2
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_J)) {
			model.setPlayer2Direction(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_L)) {
			model.setPlayer2Direction(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_I)) {
			model.setPlayer2Direction(NORTH);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_K)) {
			model.setPlayer2Direction(SOUTH);
		}
	}

	public void handleWinner() {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY); // "clear" indicator display by
		// drawing rectangle over it
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);

		if (model.getWinner().equals(StdDraw.YELLOW)) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(0.5, 0.12, "Player 1 Wins!");
		}

		if (model.getWinner().equals(StdDraw.BLUE)) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(0.5, 0.12, "Player 2 Wins!");
		}

		StdDraw.text(0.5, 0.08, "Press SPACE to play again");
	}

	// bottleneck is RIGHT HERE, mabye dynamically redraw?
	public void showBoard() {
		Color[][] display = model.getBoard();

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display.length; j++) {

				double pieceSize = 0.35 / display.length;

				double xLocation = (j * pieceSize * 2) + 0.15;// change this
				double yLocation = (i * pieceSize * 2) + 0.21;// change this

				if (display[i][j] != null) {
					if (display[i][j].equals(Color.YELLOW)) {
						StdDraw.setPenColor(player1Color);
						StdDraw.filledRectangle(xLocation, yLocation, pieceSize, pieceSize); // change
																								// this
					}

					else if (display[i][j].equals(Color.BLUE)) {
						StdDraw.setPenColor(player2Color);
						StdDraw.filledRectangle(xLocation, yLocation, pieceSize, pieceSize);// change
																							// this
					}
				}
			}
		}
		StdDraw.show();
	}

	// dynamically redraws board to be faster
	public void showBoardFast() {
		
		double pieceSize = 0.35 / BOARD_SIZE;
		double player1X = (model.getPlayer1().getX() * pieceSize * 2) + 0.15;// change this
		double player1Y = (model.getPlayer1().getY() * pieceSize * 2) + 0.21;// change this
		double player2X = (model.getPlayer2().getX() * pieceSize * 2) + 0.15;// change this
		double player2Y = (model.getPlayer2().getY() * pieceSize * 2) + 0.21;// change this
		
		StdDraw.setPenColor(player1Color);
		StdDraw.filledRectangle(player1X, player1Y, pieceSize, pieceSize); 

		StdDraw.setPenColor(player2Color);
		StdDraw.filledRectangle(player2X, player2Y, pieceSize, pieceSize);
																			
		StdDraw.show();
	}

	public void waitForSpace() {
		while (!StdDraw.isKeyPressed(32)) {
			// wait for space to be pressed
		}
	}

	public void runGame() {
		model = new TronModel(BOARD_SIZE);

		drawBasic();
		waitForSpace();

		while (!model.isGameOver()) {
			handleKeyPresses();
			showBoardFast();
			model.movePlayers();
			StdDraw.pause(SPEED); // slow game clock for testing!
			System.out.println("clock");
		}

		handleWinner();
		waitForSpace();
		runGame(); // run game again
	}

}

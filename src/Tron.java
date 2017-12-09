
/*WISH LIST
 *Color setup GUI
 * 
 */

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

	public final int BOARD_SIZE = 40; // size of board

	public int player1Points = 0;
	public int player2Points = 0;

	public int gameSpeed = 50;

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
	}

	public void difficultySelect() {
		clearInfoDisplay();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Difficulty");

		StdDraw.text(0.2775, 0.085, "Easy");
		StdDraw.text(0.5, 0.085, "Medium");
		StdDraw.text(0.7225, 0.085, "Hard");

		// wait for click in three regions
		while (!StdDraw.isMousePressed()) {
		}

		// calculate mouse ranges, if within bounds, continue
		if (StdDraw.mouseY() < 0.18 && StdDraw.mouseY() > 0.02 && StdDraw.mouseX() > 0.055
				&& StdDraw.mouseX() < 0.945) {
			if (StdDraw.mouseX() < 0.4255) {
				System.out.println("EASY");
				gameSpeed = 80;
			} else if (StdDraw.mouseX() < 0.648) {
				System.out.println("MEDIUM");
				gameSpeed = 50;
			} else {
				System.out.println("HARD");
				gameSpeed = 30;
			}
		} else {
			difficultySelect();
		}
	}

	public void drawTutorial() {
		clearInfoDisplay();

		StdDraw.setPenColor(StdDraw.BLACK);
		// draw tutorial text
		StdDraw.text(0.25, 0.15, "Player 1");
		StdDraw.text(0.25, 0.1, "Steer with WASD");

		StdDraw.text(0.75, 0.15, "Player 2");
		StdDraw.text(0.75, 0.1, "Steer with IJKL");

		StdDraw.text(0.5, 0.05, "SPACE to start");

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.25, 0.05, "Points: " + player1Points);
		StdDraw.text(0.75, 0.05, "Points: " + player2Points);
	}

	public void clearInfoDisplay() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.10, 0.445, 0.085);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
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
		clearInfoDisplay();
		StdDraw.setPenColor(StdDraw.BLACK);
		
		if(model.getWinner() == null){
			StdDraw.text(0.5, 0.12, "Nobody Wins!");
		}
		
		else if (model.getWinner().equals(StdDraw.YELLOW)) {
			StdDraw.text(0.5, 0.12, "Player 1 Wins!");
			player1Points++;
		}

		else {
			StdDraw.text(0.5, 0.12, "Player 2 Wins!");
			player2Points++;
		}

		StdDraw.text(0.5, 0.08, "Press SPACE to play again");
	}

	public void showBoard() {
		Color[][] display = model.getBoard();

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display.length; j++) {

				double pieceSize = 0.35 / display.length;

				double xLocation = (j * pieceSize * 2) + 0.15;
				double yLocation = (i * pieceSize * 2) + 0.21;

				if (display[i][j] != null) {
					if (display[i][j].equals(Color.YELLOW)) {
						StdDraw.setPenColor(player1Color);
						StdDraw.filledRectangle(xLocation, yLocation, pieceSize, pieceSize);
					}

					else if (display[i][j].equals(Color.BLUE)) {
						StdDraw.setPenColor(player2Color);
						StdDraw.filledRectangle(xLocation, yLocation, pieceSize, pieceSize);
																							
					}
				}
			}
		}

	}

	// dynamically redraws board to be faster
	public void showBoardFast() {

		double pieceSize = 0.35 / BOARD_SIZE;
		double player1X = (model.getPlayer1().getX() * pieceSize * 2) + 0.15;						
		double player1Y = (model.getPlayer1().getY() * pieceSize * 2) + 0.21;						
		double player2X = (model.getPlayer2().getX() * pieceSize * 2) + 0.15;				
		double player2Y = (model.getPlayer2().getY() * pieceSize * 2) + 0.21;
																			

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
		difficultySelect();
		drawTutorial();
		waitForSpace();

		while (true) {
			StdDraw.enableDoubleBuffering();
			while (!model.isGameOver()) {
				handleKeyPresses();
				showBoardFast();
				model.movePlayers();
				StdDraw.pause(gameSpeed); // slow game clock for testing!
				System.out.println("clock");
			}
            
			StdDraw.disableDoubleBuffering(); //have to disable to make some static changes
			handleWinner();
			waitForSpace(); 
			
			model = new TronModel(BOARD_SIZE);
			drawBasic();
			drawTutorial();
		}
	}

}

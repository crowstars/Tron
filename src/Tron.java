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
		Player Player1 = model.getPlayer1();
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_A)) {
			Player1.setDirection(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_D)) {
			Player1.setDirection(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_W)) {
			Player1.setDirection(NORTH);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_S)) {
			Player1.setDirection(SOUTH);
		}

		Player Player2 = model.getPlayer2();
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_J)) {
			Player2.setDirection(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_L)) {
			Player2.setDirection(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_I)) {
			Player2.setDirection(NORTH);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_K)) {
			Player2.setDirection(SOUTH);
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
	
	//all of the set bounds assume a board of size 20...
	public void showBoard(){
		Color[][] display = model.getBoard();

		for (int i = 0; i < 20; i++) { 
			for (int j = 0; j < 20; j++) { 
				
				double xLocation = ((j + 1) * 0.035) + 0.15; 
				double yLocation = ((i + 1) * 0.035) + 0.21;
				
				if(display[i][j] != null){
				if (display[i][j].equals(Color.YELLOW)) {
					StdDraw.setPenColor(player1Color);
					StdDraw.filledRectangle(xLocation, yLocation, 0.0175, 0.0175);
				}

				else if (display[i][j].equals(Color.BLUE)) {
					StdDraw.setPenColor(player2Color);
					StdDraw.filledRectangle(xLocation, yLocation, 0.0175, 0.0175);
				}
				}
			}
		}
		StdDraw.show();
	}

	public void waitForSpace(){
		while (!StdDraw.isKeyPressed(32)) { // 32 is the num value for the space
			// bar
// wait for space to be pressed
}
	}
	
	//used for debugging
	public void printColorArray(Color[][] toPrint){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				if(toPrint[j][i] != null){
					System.out.print(toPrint[j][i].toString() + " ");
				}
				else{
					System.out.print("blank ");
				}
			}
			System.out.println();
		}
	}
	
	public void runGame() {
 		model = new TronModel(20);

		drawBasic();
		waitForSpace();

		while (true) {
			handleKeyPresses();
			showBoard();
			if(model.getWinner() != null) break;
			model.movePlayers();
			StdDraw.pause(50); //slow game clock for testing!
			System.out.println("clock");
		}

		handleWinner();

		waitForSpace();
		runGame(); // run game again
	}

}

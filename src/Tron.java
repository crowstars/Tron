/* 
 * TRON: A clone of the classic arcade game by the same name
 * By Kenny Tran, Quinn Vinlove, Sarah Wood, and Xiya Yu
 * 
 * Background sound from "8-Bit Sound Effects Library" by LittleRobotSoundFactory on freesound.org (CC BY 3.0)
 * 	https://freesound.org/people/LittleRobotSoundFactory/packs/16681/
 * 
 * Player collision sound from "Mono tron bike engine.wav" by HiccupVirus on freesound.org (CC BY 3.0)
 * 	https://freesound.org/people/Hiccupvirus/sounds/33479/
 */

import java.awt.Color;

public class Tron {

	/** Direction variables */
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;

	/** Model for Tron */
	public TronModel model;

	/** Initial board size */
	public int boardSize = 40;

	/** Initial player points */
	public int player1Points = 0;
	public int player2Points = 0;

	/** Initial player colors */
	public Color player1Color = StdDraw.BLUE;
	public Color player2Color = StdDraw.YELLOW;

	/** Initial game speed */
	public int gameSpeed = 50;

	/** Initial sound options */
	public boolean effectsOn = true;
	public boolean soundtrackOn = true;

	/** Main Method */
	public static void main(String args[]) {
		new Tron().runGame(); //breaks main program out of void methods
	}

	/** Draws game board */
	public void drawBasic() {

		// Color window
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);

		// Add borders around windows
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.10, 0.445, 0.085);
		StdDraw.filledRectangle(0.5, 0.56, 0.355, 0.355);

		// Draw windows
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
		StdDraw.filledRectangle(0.5, 0.56, 0.35, 0.35);

		// Set title text
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.95, "Tron!");
	}

	/** Allows players to choose difficulty options and changes game speed */
	public void difficultySelect() {
		clearInfoDisplay();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Difficulty");

		StdDraw.text(0.2775, 0.085, "Easy");
		StdDraw.text(0.5, 0.085, "Medium");
		StdDraw.text(0.7225, 0.085, "Hard");

		switch (threeOptionMenu()) {
		case 0:
			difficultySelect();
			break;
		case 1:
			gameSpeed = 80;
			break;
		case 2:
			gameSpeed = 50;
			break;
		case 3:
			gameSpeed = 30;
			break;
		}

	}

	/** Allows player 1 to select their player color */
	public void player1ColorSelect() {
		clearInfoDisplay();

		//Fancy colored text acts as preview for selection 
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Player 1 Color");

		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.text(0.2775, 0.085, "Orange");

		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(0.5, 0.085, "Yellow");

		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.7225, 0.085, "Red");

		switch (threeOptionMenu()) {
		case 0:
			player1ColorSelect();
			break;
		case 1:
			player1Color = StdDraw.ORANGE;
			break;
		case 2:
			player1Color = StdDraw.YELLOW;
			break;
		case 3:
			player1Color = StdDraw.RED;
			break;
		}

	}

	/** Allows player 2 to select their player color */
	public void player2ColorSelect() {
		clearInfoDisplay();

		//Fancy colored text acts as preview for selection
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Player 2 Color");

		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.text(0.2775, 0.085, "Green");

		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.text(0.5, 0.085, "BLUE");

		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(0.7225, 0.085, "White");

		switch (threeOptionMenu()) {
		case 0:
			player2ColorSelect();
			break;
		case 1:
			player2Color = StdDraw.GREEN;
			break;
		case 2:
			player2Color = StdDraw.BLUE;
			break;
		case 3:
			player2Color = StdDraw.WHITE;
			break;
		}
	}

	/** Allows players to select board size and changes game board size */
	public void boardSizeSelect() {
		clearInfoDisplay();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Board Size");

		StdDraw.text(0.2775, 0.085, "Small");
		StdDraw.text(0.5, 0.085, "Medium");
		StdDraw.text(0.7225, 0.085, "Large");

		switch (threeOptionMenu()) {
		case 0:
			boardSizeSelect();
			break;
		case 1:
			boardSize = 30;
			break;
		case 2:
			boardSize = 50;
			break;
		case 3:
			boardSize = 70;
			break;
		}
	}

	/** Allows players to choose sound options and changes game sound */
	public void soundOptions() {
		clearInfoDisplay();

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.15, "Select Sound Options");

		StdDraw.text(0.2775, 0.085, "On");
		StdDraw.text(0.5, 0.085, "Off");
		StdDraw.text(0.7225, 0.085, "SFX only");

		switch (threeOptionMenu()) {
		case 0:
			soundOptions();
			break;
		case 1:
			effectsOn = true;
			soundtrackOn = true;
			break;
		case 2:
			effectsOn = false;
			soundtrackOn = false;
			break;
		case 3:
			effectsOn = true;
			soundtrackOn = false;
			break;
		}
	}

	/** Allows players to click on three options that appear in game in the bottom display */
	public int threeOptionMenu() {
		while (!StdDraw.isMousePressed()) { // Wait for mouse press
		}

		while (StdDraw.isMousePressed()) { // Wait for mouse to be released
		}

		//returns the third of the display that the click was in
		//display is broken up like [1, 2, 3] 
		if (StdDraw.mouseY() < 0.18 && StdDraw.mouseY() > 0.02 && StdDraw.mouseX() > 0.055
				&& StdDraw.mouseX() < 0.945) {
			if (StdDraw.mouseX() < 0.4255)
				return 1;

			else if (StdDraw.mouseX() < 0.648)
				return 2;

			else
				return 3;
		}
		
		//returns 0 if click is outside of defined space
		return 0;
	}

	/** Displays game instructions and point system to players */
	public void drawTutorial() {
		clearInfoDisplay();

		// draw tutorial text
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.25, 0.15, "Player 1");
		StdDraw.text(0.25, 0.1, "Steer with WASD");

		StdDraw.text(0.75, 0.15, "Player 2");
		StdDraw.text(0.75, 0.1, "Steer with IJKL");

		StdDraw.text(0.5, 0.05, "SPACE to start");

		//draw points that each player has
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.25, 0.05, "Points: " + player1Points);
		StdDraw.text(0.75, 0.05, "Points: " + player2Points);
	}

	/** Clears info display when game starts */
	public void clearInfoDisplay() {
		//covers bottom display with new, identical box
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.10, 0.445, 0.085);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
	}

	/** Handles key presses */
	public void handleKeyPresses() {
		// Copied from the Learn Java in N Games program AsteroidRally

		// Scan inputs for player 1
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

		// Scan inputs for player 2
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

	/**
	 * Sets conditions for and declares winners. Allows players to play game again
	 */
	public void handleWinner() {
		clearInfoDisplay();
		StdDraw.setPenColor(StdDraw.BLACK);

		if (model.getWinner() == null) {
			StdDraw.text(0.5, 0.15, "Nobody Wins!");
		}

		else if (model.getWinner().equals(StdDraw.YELLOW)) {
			StdDraw.text(0.5, 0.15, "Player 1 Wins!");
			player1Points++;
		}

		else {
			StdDraw.text(0.5, 0.15, "Player 2 Wins!");
			player2Points++;
		}
		
		StdDraw.text(0.25, 0.1, "Points: " + player1Points);
		StdDraw.text(0.75, 0.1, "Points: " + player2Points);

		StdDraw.text(0.5, 0.05, "Press SPACE to play again");
	}

	/** Draws player light trails */
	public void showBoardFast() {
        
		/*
		 * Made it so light trails are added onto display without having to scan through entire array of every single 
		 * light trail on the board, whcih is much slower, especially with larger game fields. 
		 * Because trails only appear directly behind a player and nowhere else, we can 
		 * safely assume this. This is one "beautiful implementation"
		 */
		
		double pieceSize = 0.35 / boardSize;
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

	/** Plays death sound */
	public void playDeathSound() {
		if (effectsOn) //checks to see if sound effects are set to 'on'
			StdAudio.play("lose.wav");
	}

	/** Plays soundtrack */
	public void playSoundtrack() {
		if (soundtrackOn) //checks to see if soundtrack is set to 'on'
			StdAudio.loop("background.wav");
	}

	/** Waits for space to be pressed */
	public void waitForSpace() {
		while (!StdDraw.isKeyPressed(32)) {
			// Wait for space to be pressed
		}
	}

	/** Runs game and sets options for players to choose */
	public void runGame() {

		drawBasic();
		
		//shows all of the game configuration options in a row before the game starts
		soundOptions();
		difficultySelect();
		boardSizeSelect();
		player1ColorSelect();
		player2ColorSelect();
		
		//draws tutorial text and waits for game to be started
		drawTutorial();
		waitForSpace();
		playSoundtrack();
		
		//runs infinite loop after initial setup until game is stopped 
		while (true) {
			model = new TronModel(boardSize);
			StdDraw.enableDoubleBuffering();

			//runs through the game clock until the isGameOver() method from the model returns true
			while (!model.isGameOver()) {
				handleKeyPresses(); //scans for key presses
				showBoardFast(); //shows the board
				model.movePlayers(); //moves players
				StdDraw.pause(gameSpeed); //adjustable delay for game clock
			}

			StdDraw.disableDoubleBuffering(); // Have to disable to be able to write over things
			playDeathSound();
			handleWinner(); //show winner, then wait
			waitForSpace();

			drawBasic(); //draw everything over again for a fresh start 
			drawTutorial();
		}
	}

}

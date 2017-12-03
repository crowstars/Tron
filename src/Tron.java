import java.awt.Color;

public class Tron {
	public static void main(String args[]){
		
		TronModel model = new TronModel(20);
		
		drawBasic();
		
		while(model.getWinner() == null){
			Color[][] display = model.getBoard();
			//NOTE: one unit of the display is 0.035
			//coords start at 0.15, 0.21 and build from there 
		}
		
		
		StdDraw.show();
		
	}
	
	public static void drawBasic(){
		//Color window 
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
		
		//add borders around windows
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0.5, 0.10, 0.445, 0.085);
		StdDraw.filledRectangle(0.5, 0.56, 0.355, 0.355);
		
		//draw windows
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
		StdDraw.filledRectangle(0.5, 0.56, 0.35, 0.35); 
		
		//set title text 
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.95, "Tron!");
		
		//draw tutorial text, 3 layers????
		StdDraw.text(0.25, 0.15, "Player 1");
		StdDraw.text(0.25, 0.1, "Steer with WASD");
		
		StdDraw.text(0.75, 0.15, "Player 2");
		StdDraw.text(0.75, 0.1, "Steer with IJKL");

		StdDraw.text(0.5, 0.05, "Press SPACE to start");
	}
	
    
	/*
  public void handleKeyPresses() {
  //Copied from the Learn Java in N Games program AsteroidRally
		//Player Player1 = model.getPlayer1();
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_A)) {
			tronModel.player1move(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_D)) {
	 		tronModel.player1move(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_W)) {
			tronModel.player1move(NORTH);
		}
                if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_S)) {
			tronModel.player1move(SOUTH);
                }
      
		//Player Player2 = model.getPlayer2();
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_J)) {
			tronModel.player2move(WEST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_L)) {
			tronModel.player2move(EAST);
		}
		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_I)) {
    			tronModel.player2move(NORTH);
		}
    		if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_K)) {
    			tronModel.player2move(SOUTH);
    	        }
	}
	*/

  
}

import java.awt.Color;

public class Tron {
	public static void main(String args[]){
		
		TronModel model = new TronModel(20);
		
		drawBasic();
		
		while(model.getWinner() == null){
			Color[][] display = model.getBoard();
			for(int i = 0; i < 20; i++){
				for(int j = 0; j < 20; j++){
					double xLocation = ((j + 1) * 0.035) + 0.15; //each unit is 0.035 * 0.035
					double yLocation = ((i + 1) * 0.035) + 0.21;
					
					display[i][j];
				}
			}
			model.movePlayers();
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

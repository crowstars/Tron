

public class Tron {
	public static void main(String args[]){
		//Print basic structure 
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
		
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(0.5, 0.10, 0.44, 0.08);
		
		StdDraw.filledRectangle(0.5, 0.56, 0.35, 0.35); 
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.95, "Tron!");
		
		StdDraw.show();
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

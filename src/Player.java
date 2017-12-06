import java.awt.Color;

public class Player {
	private int x;
	private int y;
	private Color color = null;
	private int direction;
	
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;
	
	public Player(Color color, int x, int y, int startingDirection){
		this.x = x;
		this.y = y;
		this.color = color;
		direction = startingDirection;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x >= 0){
		this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y >= 0){
		this.y = y;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}




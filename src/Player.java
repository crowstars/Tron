import java.awt.Color;

public class Player {
	
	/** Coordinate variables */
	private int x;
	private int y;
	
	/**Color variable is null */
	private Color color = null;
	
	/** Direction variable */
	private int direction;
	
	/** Specific Direction variables */
	public final int NORTH = 0;
	public final int EAST = 1;
	public final int SOUTH = 2;
	public final int WEST = 3;
	
	/** Player Object */
	public Player(Color color, int x, int y, int startingDirection){
		this.x = x;
		this.y = y;
		this.color = color;
		direction = startingDirection;
	}

	/** Gets x */
	public int getX() {
		return x;
	}

	/** Sets x */
	public void setX(int x) {
		if(x >= 0){
		this.x = x;
		}
	}

	/** Gets y */
	public int getY() {
		return y;
	}

	/** Sets y */
	public void setY(int y) {
		if(y >= 0){
		this.y = y;
		}
	}

	/** Gets color */
	public Color getColor() {
		return color;
	}

	/** Sets color */
	public void setColor(Color color) {
		this.color = color;
	}

	/** Gets direction */
	public int getDirection() {
		return direction;
	}

	/** Sets direction */
	public void setDirection(int direction) {
		this.direction = direction;
	}
}




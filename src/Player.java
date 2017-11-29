import java.awt.Color;

public class Player {
	private int x;
	private int y;
	private Color color = null;
	
	public Player(Color color, int x, int y){
		this.x = x;
		this.y = y;
		this.color = color;
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
}

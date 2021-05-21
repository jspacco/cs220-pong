package knox.pong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle {
	private Color color;
	private static final int width = 10;
	private static final int height = 10;
	// TODO: velocity
	private int dx = -10;
	private int dy = 0;
	
	public void reflectX() {
		dx *= -1;
	}
	
	public void reflectY() {
		dy *= -1;
	}
	
	public void move() {
		this.x += dx;
		this.y += dy;
	}
	
	public Ball(int x, int y) {
		super(x - width/2, y - height/2, width, height);
		this.color = Color.BLUE;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		// g.fillRect(x - width/2, y - width/2, width, height);
		g.fillRect(x, y, width, height);
		
	}
}

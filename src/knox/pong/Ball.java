package knox.pong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle {
	private Color color;
	private static final int width = 10;
	private static final int height = 10;
	Random random;
	private int dx = -30;
	private int dy = 0;
	int initialSpeed = 2;
	
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
		Random randDir = new Random();
		int rXDir = randDir.nextInt(2);
		if (rXDir == 0)
			rXDir--;
		setXDirection(rXDir*initialSpeed);
		
		int rYDir = randDir.nextInt(3);
		if (rYDir == 0)
			rYDir--;
		setYDirection(rYDir*initialSpeed);
		
		
	}
	public void setXDirection(int rXDir) {
		 dx = rXDir;
	}
	public void setYDirection(int rYDir) {
		 dy = rYDir;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		// g.fillRect(x - width/2, y - width/2, width, height);
		g.fillRect(x, y, width, height);
		
	}
}

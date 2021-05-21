package knox.pong;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends Rectangle {
	private Color color;
	private static final int width = 10;
	private static final int height = 60;
	
	public Paddle(int x, int y) {
		super(x - width/2, y - height/2, width, height);
		this.color = Color.RED;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, width, height);
	}
}

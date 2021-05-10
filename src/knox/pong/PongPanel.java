package knox.pong;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PongPanel extends JPanel {
	private Paddle left;
	private Paddle right;
	private Ball ball;
	private int width = 800;
	private int height = 600;
	
	public PongPanel(Paddle left, Paddle right, Ball ball) {
		this.left = left;
		this.right = right;
		this.ball = ball;
	}

	@Override
	public void paint(Graphics g) {
		left.draw(g);
		right.draw(g);
		ball.draw(g);
	}

	@Override
	public Dimension getMinimumSize() {
        return new Dimension(width, height);
    }
    
	@Override
    public Dimension getMaximumSize() {
        return new Dimension(width, height);
    }
    
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
	@Override
    public boolean isFocusable() {
        return true;
    }
}

package knox.pong;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pong extends JFrame {
	
	private PongPanel panel;
	private Paddle left;
	private Paddle right;
	private Ball ball;
	private Timer timer;
	private boolean paused = false;
	int p1, p2;
	
	public Pong() {
		setTitle("Pong!");
		p1 = 0;
		p2 = 0;
		left = new Paddle(55, 300, 1);
		right = new Paddle(745,300, 2);
		newBall();
		
		panel = new PongPanel(left, right, ball);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setResizable(false);
        this.pack();
        this.setLocation(100,100);
        this.setFocusable(true);
        
        // Add key and mouse listeners to our canvas
        initializeMouseListener();
        initializeKeyListener();
        
        // initialize the menu options
        initializeMenu();

        // Handle closing the window.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveBall();
			}
		});
        timer.start();
		
	}
	public void newBall() {
		ball = new Ball(400, 300);
	}
	private void moveBall() {
		ball.move();
		if (ball.intersects(left)) {
			System.out.println("Ball intersects left paddle!");
			ball.reflectX();
		}
		if (ball.intersects(right)) {
			System.out.println("Ball intersects right paddle!");
			ball.reflectX();
		}
		if (ball.x <= 0) {
			ball.setXDirection(+1);
			p1++;
			newBall();
			System.out.println("Player 2: "+ p2);
			
	}
		if (ball.x >= 800) {
			ball.setXDirection(-1);
			p2++;
			newBall();
			System.out.println("Player 1: "+ p1);
		}
		if (ball.y <= 20 ) {
			ball.setYDirection(+1);
		}
		
		if (ball.y >= 585) {
			ball.setYDirection(-1);
		}
		repaint();
	}
	
	private void initializeMouseListener() {
		// if we need to use the mouse
	}
	
	private void initializeKeyListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if (key == ' ' || key == 'f' && !paused) {
					System.out.println("pause!");
					if (paused) {
						timer.restart();
						paused = false;
					} else {
						timer.stop();
						paused = true;
					}
				} else if (key == 'f') {
					System.out.println("frame advance!");
					moveBall();
				}
				
			}
			public void keyPressed(KeyEvent e) {
				left.keyPressed(e);
				right.keyPressed(e);
			}
			@SuppressWarnings("unused")
			public void keyRelease(KeyEvent e) {
				left.keyRelease(e);
				right.keyRelease(e);
			}
		});
		
	}
	
	private void initializeMenu() {
		// create jmenubar here
	}
	
	public static void main(String[] args) {
		Pong p = new Pong();
		p.setVisible(true);
	}
}

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
	
	public Pong() {
		setTitle("Pong!");
		
		left = new Paddle(55, 300);
		right = new Paddle(745, 300);
		ball = new Ball(400, 300);
		
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
        
        timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.move();
				if (ball.intersects(left)) {
					System.out.println("Ball intersects left paddle!");
					ball.reflectX();
				}
				if (ball.intersects(right)) {
					System.out.println("Ball intersects left paddle!");
					ball.reflectX();
				}
				repaint();
			}
		});
        timer.start();
		
	}
	
	private void initializeMouseListener() {
		// if we need to use the mouse
	}
	
	private void initializeKeyListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if (key == ' ') {
					System.out.println("pause!");
					if (paused) {
						timer.restart();
						paused = false;
					} else {
						timer.stop();
						paused = true;
					}
				}
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

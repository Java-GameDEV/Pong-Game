import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	JFrame frame; // Window of the game
	public final int WIDTH = 400; // Width of window
	public final int HEIGHT = WIDTH / 16 * 9; // Height of window
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT); // Size of window (Width + Height - *1 variable for both*)
	public final String TITLE = "Pong";
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	static boolean gameRunning = false;
	
	public void run() {
		while (gameRunning) { // If gameRunning = true
			tick();
			render();
		}
	}
	
	public synchronized void start() {
		gameRunning = true;
		new Thread(this).start();
	}	// End start method
	
	public static synchronized void stop() {
		gameRunning = false;
		System.exit(0);
	} // End stop method
	
	
	public Game() {
		frame = new JFrame();
		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
	}
	
	public void tick() {
		
	}
	
	public void render() {
		BufferStrategy bs =	getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}

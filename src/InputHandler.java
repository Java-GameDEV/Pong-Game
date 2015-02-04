import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class InputHandler implements KeyListener{

	public InputHandler(Game game){
		game.addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == e.VK_UP) {
			Game.player.goingUp = true; 
		}
		if (keyCode == e.VK_DOWN) {
			Game.player.goingDown = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == e.VK_UP) {
			Game.player.goingUp = false; 
		}
		if (keyCode == e.VK_DOWN) {
			Game.player.goingDown = false;
		}
	}

	
	
	

}

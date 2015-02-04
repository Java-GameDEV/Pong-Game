import java.awt.Color;
import java.awt.Graphics;


public class PlayerPaddle {

	int x;
	int y;
	int width = 15;
	int height = 40;
	
	int speed = 3;
	
	boolean goingUp = false;
	boolean goingDown = false; 
	
	public PlayerPaddle(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(Game game){
		if (goingUp && y > 0) {
			y -= speed;
		}
		if (goingDown && y < game.getHeight() - height) {
			y += speed;
		}
	}
	
	public void render(Graphics	g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}

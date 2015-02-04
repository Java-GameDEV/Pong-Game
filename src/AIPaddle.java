import java.awt.Color;
import java.awt.Graphics;


public class AIPaddle {
	int x;
	int y;
	int width = 15;
	int height = 40;
	
	int speed = 3;
	
	boolean goingUp = false;
	boolean goingDown = false; 
	
	public AIPaddle(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(Game game){
		if (game.player.y < y) {
			y-=speed;
		}
		if (game.player.y > y) {
			y+=speed;
		}
	}
	
	public void render(Graphics	g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}

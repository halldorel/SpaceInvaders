import java.awt.*;
import java.awt.event.*;

public class Invader {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 24;
	private static final boolean ALIVE = true;
	private static final boolean DEAD = false;
	
	private double x, y;
	private Rectangle bounds;
	private boolean status;
	public Shot EvilBomb;
	private boolean xDir;
	
	public Invader(double x, double y, Shot EvilBomb) {
		this.status = ALIVE;
		this.x = x;
		this.y = y;
		this.EvilBomb = EvilBomb;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void explode() {
		status = false;
		Explosion e = new Explosion(50, x + WIDTH/2, y + HEIGHT/2 );
	}
	
	public void shoot() {
		this.EvilBomb = new Shot(this.x, this.y, -1, true);
	}
	
	public void kill() {
		status = false;
	}
	
	public Rectangle getBounds() {
		bounds = new Rectangle(this.x, this.y, this.x + WIDTH, this.y + HEIGHT);
		return bounds;
	}
	
	public void move(boolean xDir) {
		if(xDir) {
			this.getBounds().setX(this.getBounds().getX() + 4); 
		}
		else this.getBounds().setX(this.getBounds().getX() - 4);
	}
	
	public void update(boolean xDir) {
		if(status) {
			this.move(xDir);
		}
	}
	public void render() {
		(this.bounds).show();
	}

}
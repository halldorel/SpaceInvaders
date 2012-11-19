import java.awt.*;
import java.awt.event.*;

public class Hero
{
	//  0 < x < 512 staðsetning hetju
	private double x;
	
	// Hraði hetju
	private static final int SPEED = 4;
	
	// Búum til Rectangle hlut fyrir hetjuna
	private Rectangle bounds;
	
	// y staðsetning hetju
	private static double y = 0;

	// Stærð hetju
	private static final int WIDTH = 30;
	private static final int HEIGHT = 10;

	// Fastar
	private static final int DX = 4;
	private static final int X_OFFSET = WIDTH/2;
	
	// Leyfilegt svæði hetju
	private static final double MIN_X = 0	+X_OFFSET;
	private static final double MAX_X = 512	-X_OFFSET;
	
	// Lyklar fyrir vinstri-hægri hreyfingar hetju og skot
	private static final int LEFT = KeyEvent.VK_A;
	private static final int RIGHT = KeyEvent.VK_D;
	private static final int SPACE = KeyEvent.VK_SPACE;
		
	// Er hetja lifandi?
	private static boolean alive = true;
	
	// Constructor
	private static final int INIT_LIVES = 5;

	private int lives;
	private Explosion explosion;
	private Shot HeroShot;
	
	public Hero(double x, Shot HeroShot)
	{
		this.x = x;
		this.lives = INIT_LIVES;
		this.alive = true;
		this.HeroShot = HeroShot;
		
		// Búum til sprengingu af stærð núll til þess að explosion.update()
		// krassi ekki forritinu.
		explosion = new Explosion(0, 1, 1);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Rectangle getBounds() {
		bounds = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		return bounds;
	}
	
	public void update()
	{
		
		if (lives <= 0)
			{	this.alive = false;	}
			
		
		if (StdDraw.isKeyPressed(LEFT))
			{
				// GAME FRAME - breyta skv Game.java
				if (this.bounds.getX() > MIN_X + WIDTH/2)
				{
					this.bounds.setX(bounds.getX() - SPEED);
				}
			}
		else if (StdDraw.isKeyPressed(RIGHT))
			{
				// GAME FRAME
				if (this.bounds.getX() < MAX_X - WIDTH/2)
				{
					this.bounds.setX(bounds.getX() + SPEED);
				}
			}	
		explosion.update();
	}
	
	// Er leikmaður lifandi?
	public boolean isAlive()
	{
		return alive;
	}
	
	public void subtractLive()
	{
		lives--;
		explosion = new Explosion(20, x, y);
	}
	
	public void render()
	{
		if (this.alive) {
			(this.getBounds()).show();
			StdDraw.picture(x, y, "/src/img/gun.png"); 
		}
		//explosion.render();
	}
}
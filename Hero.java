import java.awt.*;
import java.awt.event.*;

public class Hero
{
	//  0 < x < 512 staðsetning hetju
	private double xpos;
	
	// Hraði hetju
	private static final int SPEED = 4;
	
	// Búum til Rectangle hlut fyrir hetjuna
	private Rectangle hero;
	
	// y staðsetning hetju
	private static double ypos = 0;
	
	// Leyfilegt svæði hetju
	private static final double MIN_X = 0;
	private static final double MAX_X = 512;
{			
	// Fastar
	private static final int DX = 4;

	private static final int X_OFFSET = 5;
	
	// Leyfilegt svæði hetju
	private static final double MIN_X = 0	+X_OFFSET;
	private static final double MAX_X = 512	-X_OFFSET;
	
	// Lyklar fyrir vinstri-hægri hreyfingar hetju
	private static final int LEFT = KeyEvent.VK_A;
	private static final int RIGHT = KeyEvent.VK_D;
	
	// Stærð hetju
	private static final int WIDTH = 30;
	private static final int HEIGHT = 10;
	
	// Er hetja lifandi?
	private static boolean alive = true;
	
	// Constructor
	private static final int INIT_LIVES = 5;
	
	//  0 < x < 512 staðsetning hetju
	private double xpos;
	// y staðsetning hetju
	private static double ypos = 0;
	// Búum til Rectangle hlut fyrir hetjuna
	private Rectangle bounds;
	private int lives;
	private Explosion explosion;
	private boolean alive;
	
	
	public Hero(double xpos)
	{
		this.xpos = xpos;
		// ATH hér eru einhverjar temp stærðir á hetju (30, 10))
		this.bounds = new Rectangle(xpos, ypos, 30, 10);
		this.hero = new Rectangle(xpos, ypos, 30, 10);
		this.lives = INIT_LIVES;
		this.alive = true;
		
		// Búum til sprengingu af stærð núll til þess að explosion.update()
		// krassi ekki forritinu.
		explosion = new Explosion(0, 1, 1);
	}
	
	public double getX()
	{
		return this.xpos;
	}



	public void update()
	{
	
		if (this.collides(game.EvilBomb) {
			this.lives--;
			explosion = new Explosion(20, xpos, ypos);
		}
		if (lives <= 0)
			{	this.alive = false;	}
			
		
		if (StdDraw.isKeyPressed(LEFT))
			{
				// GAME FRAME - breyta skv Game.java
				if (this.xpos > MIN_X + WIDTH/2)
				{
					bounds.setX(bounds.getX() - SPEED);
				}
			}
		else if (StdDraw.isKeyPressed(RIGHT))
			{
				// GAME FRAME
				if (this.xpos < MAX_X - WIDTH/2)
				{
					bounds.setX(bounds.getX() + SPEED);
				}
			}
	}
	
	// Er leikmaður lifandi?
	public boolean isAlive()
	{
		return alive;
	}
	
	public void kill()
	{
		this.alive = false;
	}

	public void draw()
	{
		// Rectangle draw
		bounds.show();
	}

	public boolean collides(Rectangle r)
	{
		return this.bounds.intersects(r);
		{
			if (this.xpos > MIN_X)
				{	xpos = (xpos - DX);		}
		}
		else if (StdDraw.isKeyPressed(RIGHT))
		{
			if (this.xpos < MAX_X)
				{	xpos = (xpos + DX);		}
		}
		
		explosion.update();

	}
	
	
	
	public void render()
	{
		if this(alive) {
			hero.show();
		}
		explosion.render();
	}
		
	public void shoot()
	{
		game.HeroShot = new Shot(xpos, ypos, true, true);
	}

	// Test client
	public static void main(String[] args)
	{
		while(true)
		{
			StdDraw.rectangle(1, 1, 1, 1);
		}
	}
}
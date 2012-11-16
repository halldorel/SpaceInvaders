import java.awt.*;
import java.awt.event.*;

public class Hero
{
	//  0 < x < 512 staðsetning hetju
	private double xpos;
	
	//Hraði hetju
	private static final int SPEED = 4;
	
	// Búum til Rectangle hlut fyrir hetjuna
	private Rectangle hero;
	
	// y staðsetning hetju
	private static double ypos = 0;
	
	// Leyfilegt svæði hetju
	private static final double MIN_X = 0;
	private static final double MAX_X = 512;
	
	// Lyklar fyrir vinstri-hægri hreyfingar hetju
	private static final int LEFT = KeyEvent.VK_A;
	private static final int RIGHT = KeyEvent.VK_D;
	
	// Stærð hetju
	private static final int WIDTH = 30;
	private static final int HEIGHT = 10;
	
	// Er hetja lifandi?
	private static boolean alive = true;
	
	// Constructor
	public Hero(double xpos)
	{
		this.xpos = xpos;
		// ATH hér eru einhverjar temp stærðir á hetju (30, 10))
		this.bounds = new Rectangle(xpos, ypos, 30, 10);
	}
	
	public double getX()
	{
		return this.xpos;
	}

	public void update()
	{
		// Bregðast við 
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
			hero.show();
		}

	public boolean collides(Rectangle r)
	{
		return this.bounds.intersects(r);
	}

	// Test client
	public static void main(String[] args)
	{
		while(true)
		{
			
		}
	}
}
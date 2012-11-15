import java.awt.*;
import java.awt.event.*;

public class Hero
{
	//  0 < x < 512 staðsetning hetju
	private double xpos;
	
	// Búum til Rectangle hlut fyrir hetjuna
	private Rectangle hero;
	
	// y staðsetning hetju
	private static double ypos = 0;
	
	// Leyfilegt svæði hetju
	private static final double MIN_X = 0	+5;
	private static final double MAX_X = 512	-5;
	
	// Lyklar fyrir vinstri-hægri hreyfingar hetju
	private static final int LEFT = KeyEvent.VK_A;
	private static final int RIGHT = KeyEvent.VK_D;
	
	// Constructor
	public Hero(double xpos)
	{
		this.xpos = xpos;
		// ATH hér eru einhverjar temp stærðir á hetju (30, 10))
		this.hero = new Rectangle(xpos, ypos, 30, 10);
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
				if (this.xpos > MIN_X)
				{
					hero.setX(hero.getX() - 4);
				}
			}
		else if (StdDraw.isKeyPressed(RIGHT))
			{
				if (this.xpos < MAX_X)
				{
					hero.setX(hero.getX() + 4);
				}
			}
	}
	
	public void draw()
		{
			// Rectangle draw
			hero.show();
		}

	// Test client
	public static void main(String[] args)
	{
		while(true)
		{
			
		}
	}
}
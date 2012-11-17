/*
 * Klasi fyrir múrsteina sem byrgi eru byggð úr.
 * Hver múrsteinn hefur þrjú líf og þrjú tilsvarandi
 * stig eyðileggingar.
 */

public class Brick
{
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	private static final int INIT_LIVES = 3;
	
	public static final int RADIUS = 8;
	
	private final double x, y;
	private final Rectangle Bounds;
	private int state;
	private int lives;
	
	public Explosion b;
	
	public Brick(double x, double y)
	{
		this.state = ALIVE;
		this.x = x;
		this.y = y;
		Bounds = new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
		this.lives = INIT_LIVES;
	}
	
	public boolean isAlive()
	{
		return this.state == ALIVE;
	}
	
	public void kill()
	{
		this.state = DEAD;
		b = new Explosion(20, this.x, this.y);
	}
/*	
	public void checkCollision()
	{
		
		// if (blablabla)	lives--;	
	}
*/	
	public void update()
	{
		if (this.isAlive()) {
			//checkCollision();
			if (lives <= 0)
				{	this.state = DEAD;	}
		}	
	}
	
	public void render()
	{
		if (this.isAlive()) {
			if (lives == 3) {
				StdDraw.picture(x, y, "/img/wall1.png");
			} else if (lives == 2) {
				StdDraw.picture(x, y, "/img/wall2.png");
			} else {
				StdDraw.picture(x, y, "/img/wall3.png2");
			}
		}
	}
	
	
}
	
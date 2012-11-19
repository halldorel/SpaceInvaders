/*
 * Klasi fyrir múrsteina sem byrgi eru byggð úr.
 * Hver múrsteinn hefur þrjú líf og þrjú tilsvarandi
 * stig eyðileggingar.
 */

public class Brick
{
	private static final int INIT_LIVES = 3;
	
	public static final int RADIUS = 8;
	
	private final double x, y;
	private final Rectangle bounds;
	private boolean alive;
	private int lives;
	
	public Explosion b;
	
	public Brick(double x, double y)
	{
		this.alive = true;
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
		this.lives = INIT_LIVES;
		this.b = new Explosion(0, 1, 1);
	}
	
	public boolean isAlive()
	{
		return this.alive;
	}
	
	public void kill()
	{
		this.alive = false;
//		b = new Explosion(20, this.x, this.y);
	}
/*	
	public void checkCollision()
	{
		
		// if (blablabla)	lives--;	
	}
*/	
	public void update(Shot HeroShot, Shot EvilBomb)
	{
		if (this.isAlive()) {
			if (bounds.intersects(HeroShot.getBounds())) {
				lives--;
				b = new Explosion(15, x, y);
				HeroShot.kill();
			}
			if (bounds.intersects(EvilBomb.getBounds())) {
				lives--;
				b = new Explosion(15, x, y);
				EvilBomb.kill();
			}
			if (lives <= 0)
				{	alive = false;	}
			b.update();
		}	
	}
	
	public void render()
	{
		if (this.isAlive()) {
			if (lives == 3) {
				StdDraw.picture(x, y, "/src/img/wall1.png");
			} else if (lives == 2) {
				StdDraw.picture(x, y, "/src/img/wall2.png");
			} else {
				StdDraw.picture(x, y, "/src/img/wall3.png2");
			}
		}
		b.render();
	}
	
	
}
	
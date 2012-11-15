public class Gun
{

	private static final int WIDTH = 32;
	private static final int HEIGHT = WIDTH/2;
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	private static final int INIT_LIVES = 5;

	private double x;
	private double Dx;
	private final Rectangle Bounds;
	private int state;

	private int lives;
	
	// Öll skot
	private Shot shot;
	
	
	// Býr til sprengingu með engum ögnum, til þess að fá ekki villu
	// þegar kallað er á d.isAlive() í updateExplosion()
	private Explosion d = new Explosion (0, 1.0, 1.0);
	
	
	
	public Gun(double x)
	{
		this.x = x;
		this.Rectangle = new Rectangle(x, y, WIDTH, HEIGHT);
		this.exists = true;
		this.lives = INIT_LIVES;
	}
	
	public boolean atLeftBounds()
	{
	}
	
	public boolean atRightBounds()
	{
	}
	
	public boolean isAlive()
	{
		return this.state == ALIVE;
	}
	
	public void kill()
	{
		this.state = DEAD;
	}
	
	public boolean collidesWith(Collider b)
	{
		Rectangle r = b.getBounds();
		return r.intersects(this.Bounds);
	}

	public void updateExplosion()
	{
		if (d.isAlive())
			{	d.update();	}
	}
	
	public void renderExplosion()
	{
		id (d.isAlive())
			{	d.render();	}
	}
	
	public void update()
	{
		if (this.collidesWith(Projectile p) {
			this.lives--;
			d = new Explosion(50, x, y);
		}
		if (lives <= 0)
			{	this.state = DEAD;	}
		if (StdDraw.isKeyPressed(2) && !this.atLeftBounds())
			{	this.x += -Dx;	}
		if (StdDraw.isKeyPressed(3) && !this.atRightBounds())
			{	this.x += Dx;	}
			
		updateShot();
		updateExplosion();
	}
			

	public void render()
	{
		if (this.isAlive()) {
			/*Teikna leikmann á skjáinn á núverandi hnitum*/
		}
		renderExplosion();
		renderShot();
	}
			
			
	public void shoot()
	{
		shot = new Shot(x);
	}
	
	public void updateShot()
	{
		if (shot.isAlive())
			{	shot.update();	}
	}
	
	public void renderShot()
	{
		if (shot.isAlive())
			{	shot.render();	}
	}
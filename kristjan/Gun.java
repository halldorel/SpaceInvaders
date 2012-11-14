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
	
	public void Draw() {
	{
	}
	
	public void update()
	{
		if (this.collidesWith(Projectile p)
			{	this.lives--;	}
		if (lives <= 0)
			{	this.state = DEAD;	}
		if (StdDraw.isKeyPressed(2) && !this.atLeftBounds())
			{	this.x += -Dx;	}
		if (StdDraw.isKeyPressed(3) && !this.atRightBounds())
			{	this.x += Dx;	}
			
	}
			

	public void render()
	{
		if (this.isAlive())
			Draw()
	}
			
			
		
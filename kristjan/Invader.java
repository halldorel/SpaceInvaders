public class Invader extends Collider
{
	private static final int WIDTH = 32;
	private static final int HEIGHT = 24;
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	
	private double x, y;
	private Rectangle Bounds;
	private int state;
	
	public Invader(double x, double y) {
		this.state = ALIVE;
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, x + WIDTH, y + HEIGHT);
	}
	
	public void endOfScreen() {
		if (this.x <= Screen.MIN || this.x >= Screen.MAX - WIDTH)
			{	game.setDx() = -( game.getDx() + 1 );	}
	}
	
	public void explode() {
		exists = false;
		Explosion e = new Explosion(50, x + WIDTH/2, y + HEIGHT/2 );
	}
	
	public boolean isAlive() {
		return this.state == ALIVE;
	}
	
	public void update() {
		if (this.isAlive()) {
			this.collisionCheck();
			this.endOfScreen();
			this.x = this.x + game.getDx();
			if (this.collidesWith(Projectile p)
				{	explode();	}
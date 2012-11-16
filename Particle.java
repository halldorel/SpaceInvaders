import java.util.Random;
import java.awt.Color;

public class Particle
{
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	
	private static final int MAX_RADIUS = 3;
	private static final int MIN_RADIUS = 2;	
	private static final int MAX_SPEED = 12;
		
	private int state;
	
	private double x, y, radius;
	private double velX, velY;
	private int red, green, blue, alpha;
	private Color color;
	
	private Random r = new Random();

	
	public boolean isAlive() {
		return this.state == ALIVE;
	}
	
	public boolean isDead() {
		return this.state == DEAD;
	}
	
	public void setState(int i) {
		if (i != 1 && i != 0)
			{	return;	  }
		this.state = i;
	}
	
	
		
	
	
	
	public Particle(double x, double y) {
		this.x = x;
		this.y = y;
		this.state = Particle.ALIVE;
		this.radius = r.nextInt(MAX_RADIUS - MIN_RADIUS) + MIN_RADIUS;
		
		this.velX = r.nextInt(MAX_SPEED);
		this.velY = r.nextInt(MAX_SPEED);
		
		velX = (r.nextInt(2) == 1) ? -velX : velX;
		velY = (r.nextInt(2) == 1) ? -velY : velY;
		
		// Hægjum á ögnum sem eru bæði með hátt velX og hátt velY
		if ((velX * velX + velY * velY) > MAX_SPEED * MAX_SPEED)
			{	velX *= 0.65;	velY *= 0.65;	}
			
		this.red = r.nextInt(255);
		this.green = r.nextInt(255);
		this.blue = r.nextInt(255);
		this.alpha = r.nextInt(55) + 200;
		
		this.color = new Color(red, green, blue, alpha);
		
	}
	
	
	public void update() {
		if (this.state != DEAD) {
			this.x += this.velX;
			this.y += this.velY;
			
			this.alpha -= 3;
			if (alpha <= 0)
				{	this.state = DEAD;	}
			else {
				color = new Color(red, green, blue, alpha);
			}
		}
	}

/*	
	// Ef við viljum að agnirnar skoppi af rammanum
	public void update(Rectangle box) {
		if (this.state != DEAD) {
			if (this.x <= box.getX() + this.radius || this.x >= box.getWidth() - this.radius)
				this.velX *= -1;
			if (this.y <= box.getY() + this.radius || this.y >= box.getHeight() - this.radius)
				this.velY *= -1;
		}
		update();
	}
*/
		
	public void render() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.x, this.y, this.radius);
	}
}
		
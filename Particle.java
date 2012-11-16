import java.util.Random;
import java.awt.Color;

public class Particle
{
	public static final int ALIVE = 1;
	public static final int DEAD = 0;
	
	public static final int LIFETIME = 100;
	public static final int MAX_RADIUS = 5;
	public static final int MAX_SPEED = 10;
	
	private int state;
	
	private double x, y, radius;
	private double velX, velY;
	private int age, lifetime;
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
		this.radius = r.nextFloat(MAX_RADIUS);
		this.lifetime = Particle.LIFETIME;
		this.age = 0;
		
		this.velX = r.nextDouble(MAX_SPEED);
		this.velY = r.nextDouble(MAX_SPEED);
		
		// Hægjum á ögnum sem eru bæði með hátt velX og hátt velY
		if ((velX * velX + velY * velY) > MAX_SPEED * MAX_SPEED)
			{	velX *= 0.65;	velY *= 0.65;	}
			
		this.red = r.nextInt(255);
		this.green = r.nextInt(255);
		this.blue = r.nextInt(255);
		this.alpha = r.nextInt(255);
		
		this.color = new Color(red, green, blue, alpha);
		
	}
	
	
	public void update() {
		if (this.state != DEAD) {
			this.x += this.velX;
			this.y += this.velY;
			
			this.alpha -= 2;
			if (alpha <= 0)
				{	this.state = DEAD;	}
			else {
				color = new Color(red, green, blue, alpha);
				this.age++;
			}
			if (this.age > this.lifetime)
				{	this.state = DEAD;	}
		}
	}
	
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
		
	public void render() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.x, this.y, this.radius);
	}
		
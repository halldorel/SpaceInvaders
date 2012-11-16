import java.util.Random;
import java.awt.Color;

public class Particle
{
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	
	private static final int MAX_RADIUS = 3;
	private static final int MIN_RADIUS = 2;	
	private static final int MAX_SPEED = 7;
		
	private int state;
	
	// Decay er bæði þyngdarafl og það sem lætur agnir dofna
	private double decay = 0;
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
		
		
		// Random litur á ögn, hver þáttur á bilinu 160 - 255
		// nema alpha sem er á bilinu 200 - 255.
		this.red = r.nextInt(95) + 160;
		this.green = r.nextInt(95) + 160;
		this.blue = r.nextInt(95) + 160;
		this.alpha = r.nextInt(55) + 200;
		
		this.color = new Color(red, green, blue, alpha);
		
	}
	
	
	public void update() {
		if (this.state != DEAD) {
			this.x += this.velX;
			this.y += this.velY - (decay / 4);
			
			this.alpha -= (decay / 16);
			decay++;
			if (alpha <= 0)
				{	this.state = DEAD;	}
			else {
				color = new Color(red, green, blue, alpha);
			}
		}
	}

	
	// Ef við viljum að agnirnar skoppi af rammanum
	public void update(boolean b) {
		if (this.state != DEAD) {
			if (x <= 0 || x >= 512) {
				this.velX *= -1;
			}
			if (y <= 0 || y >= 512)
				this.velY *= -1;
		}
		update();
	}

		
	public void render() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.x, this.y, this.radius);
	}
}
		
public class Explosion
{
	public static final int ALIVE = 1;	// Ef amk. ein ögn er eftir
	public static final int DEAD = 0;	// Ef allar agnir eru horfnar
	
	private Particle[] particles;
	private double x, y;				// Núllpunktur sprengingar
	private double gravity;
	private int size, state;
	
	
	public Explosion(int size, double x, double y) {
		this.state = ALIVE;
		this.size = size
		this.particles = new Particle[size];
		for (int i = 0; i < particles.length; i++)
			{	this.particles[i] = new Particle(x, y);	  }
	}
	
	public void update() {
		if (this.state != DEAD) {
			boolean isDead = true;
			for (int i = 0; i < particles.length; i++) {
				if (particles[i].isAlive()) {
					particles[i].update();
					isDead = false;
				}
			}
			if (isDead)
				{	this.state = DEAD;	}
		}
	}
	
	// Ef við viljum að agnirnar skoppi af rammanum
	public void update(Rectangle box) {
		if (this.state != DEAD) {
			boolean isDead = true;
			for (int i = 0; i < particles.length; i++) {
				if (particles[i].isAlive()) {
					particles[i].update(box);
					isDead = false;
				}
			}
			if (isDead)
				{	this.state = DEAD;	}
		}
	}
	
	public void render() {
		for (int i = 0; i < particles.length; i++) {
			if (particles[i].isAlive) {
				particles[i].render();
			}
		}
	}
	
	
}
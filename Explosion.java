/*
 * Þessi klasi býr til sprengingar með hjálp Particles klasans
 * hver sprenging er búin til úr N ögnum sem hafa slembinn
 * upphafshraða og slembna upphafsstefnu.
 */


public class Explosion
{
	public static final int ALIVE = 1;	// Ef amk. ein ögn er eftir
	public static final int DEAD = 0;	// Ef allar agnir eru horfnar
	
	private Particle[] particles;
	private double x, y;				// Núllpunktur sprengingar
	private int size, state;
	
	// SLR er slew rate limiter lætur update() keyra
	// einungis í annað hvert skipti sem kallað er á það.
	private byte SLR = 0;
	
	
	public Explosion(int size, double x, double y) {
		this.state = ALIVE;
		this.size = size;
		this.particles = new Particle[size];
		for (int i = 0; i < particles.length; i++)
			{	this.particles[i] = new Particle(x, y);	  }
	}
	
	public void update() {
		if (SLR == 1) {
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
			SLR = 0;
		}
		SLR++;
	}
	

	// Ef við viljum að agnirnar skoppi af rammanum
	public void update(boolean b) {
		if (this.state != DEAD) {
			boolean isDead = true;
			for (int i = 0; i < particles.length; i++) {
				if (particles[i].isAlive()) {
					particles[i].update(b);
					isDead = false;
				}
			}
			if (isDead)
				{	this.state = DEAD;	}
		}
	}
	
	public void render() {
		for (int i = 0; i < particles.length; i++) {
			if (particles[i].isAlive()) {
				particles[i].render();
			}
		}
	}
	
	
}
public class Game
{
	// Dx stjórnar hraða og stefnu óvinanna.
	private int Dx = 4;
	// 
	private boolean Dx = false;
	
	//Fjöldi invadera
	private static final int INIT_INVADERS = 36;
	private static final int INIT_BUNKERS = 5;
	private static final int INIT_LIVES = 5;
	
	//Shot 
	private Shot HeroShot;
	private Shot EvilBomb;
	
	private boolean running = true;
	
	private Hero hero;
	private int lives;
	private Explosion heroExplosion;
	
	public final Rectangle gameFrame;
	
	private Invader[] invaders;
	private Explosion invExplosion;
	private Bunker[] bunkers;
	private Explosion bunkerExplosion;
	
	private double[] invaderPos = { 48, 48, 106, 48, 164, 48, 212, 28, 270, 48, 328, 48,
									48, 106, 106, 106, 164, 106, 212, 106, 270, 106, 328, 106,
									48, 164, 106, 164, 164, 164, 212, 164, 270, 164, 328, 164,
									48, 212, 106, 212, 164, 212, 212, 212, 270, 212, 328, 212,
									48, 270, 106, 270, 164, 270, 212, 270, 270, 270, 328, 270,
									48, 328, 106, 328, 164, 328, 212, 328, 270, 328, 328, 328};

	private double[] bunkerPos = { 0, 0, 70, 0, 140, 0, 210, 0, 280, 0 };

	public Game() {
		gameFrame = new Rectangle(256, 256, 511, 511);
		
		// Hero initialized
		{
			lives = INIT_LIVES;
			HeroShot = new Shot(-1, -1, 1, false);
			hero = new Hero(256, HeroShot);
			heroExplosion = new Explosion(0, 1, 1);
		}
		
		// Invaders initialized
		{
			xDir = true;
		
			Invader[] invaders = new Invader[INIT_INVADERS];
			for (int i = 0; i < invaders.length; i += 2) {
				invaders[i] = new Invader(invaderPos[i], invaderPos[i+1], EvilBomb);
			}
			
			EvilBomb = new Shot(-1, -1, -1, false);
			invExplosion = new Explosion(0, 1, 1);
		}
		
		// Bunkers initialized
		{
			Bunker[] bunkers = new Bunker[INIT_BUNKERS];
			for (int i = 0; i < bunkers.length; i += 2) {
				bunkers[i] = new Bunker(bunkerPos[i], bunkerPos[i+1]);
			}
			
			bunkerExplosion = new Explosion(0, 1, 1);
		}
		
	}
	
	// Uppfærir stöðu allra hluta í leiknum
	
	public void update() {
		if (lives > 0)
		{
			

			HeroShot.update();
			EvilBomb.update();
			hero.update();
			
			if (hero.getBounds().intersects(EvilBomb.getBounds())) {
				lives--;
				heroExplosion = new Explosion(15, hero.getX(), hero.getY());
			}
		
			for (int i = 0; i < invaders.length; i++) {
				if (invaders[i].getBounds().intersects(gameFrame)) {
					Dx = (Dx > 0) ? (-1 * Dx) + 1 : (-1 * Dx) - 1;
					Dy = true;
					break;
				} else {
					Dy = false;
				}
			}
		
			for(int i = 0; i < invaders.length; i++) {
				if(invaders[i].getBounds().intersects(HeroShot.getBounds())) {
					invaders[i].kill();
					invExplosion = new Explosion(15, invaders[i].getX(), invaders[i].getY());
					HeroShot.kill();
					break;
				}
			}
		
			for(int i = 0; i < invaders.length; i++) {
				invaders[i].update(Dx, Dy);
			}
			
			for(int i = 0; i < bunkers.length; i++) {
				bunkers[i].update(HeroShot, EvilBomb);
			}
			
			heroExplosion.update();
			invExplosion.update();
			bunkerExplosion.update();
		}
	}
	
	/*
	 * Hreinsar skjáinn fyrst, kallar svo á allar
	 * render() aðferðir hjá öllum hlutum sem á að
	 * teikna á skjáinn.
	 */
	public void render()
	{
		gameFrame.show();
		HeroShot.render();
		EvilBomb.render();
		hero.render();
		for (int i = 0; i < invaders.length; i++) {
			invaders[i].render();
		}
		for(int i = 0; i < bunkers.length; i++) {
			bunkers[i].render();
		}
	}
	
	/*
	 * Keyrsluaðferð fyrir leik
	 */
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = (1000000000.0 /60);
		double delta = 0;
		
		int frames = 0;
		int updates = 0;
		
		/*
		 *	Keyrslulúppa fyrir leikinn.
		 *	Passar að update() sé aðeins keyrt
		 *	60 sinnum á sekúndu en render() eins
		 *	oft og hægt er.
		 */
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
				updates++;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				// FPS og UPS counter
				StdDraw.text(3.0, 3.0, "FPS: " + frames + ", UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		
		}
	}
	
	public void stop()
		{	running = false;	}
	
	//boolean xDir í stað int Dx
	public boolean getxDir()
		{	return xDir;	}
	
	public void setxDir(boolean xDir)
		{	this.xDir = xDir;	}

	
}
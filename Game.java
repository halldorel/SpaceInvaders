import java.awt.Color;

public class Game
{
	// Dx stjórnar hraða og stefnu óvinanna.
	private int Dx = 4;
	// 
	private boolean Dy = false;
	
	//Fjöldi invadera
	private static final int INIT_INVADERS = 40;
	private static final int INIT_BUNKERS = 5;
	private static final int INIT_LIVES = 5;
	
	private int counter = 0;
	
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
	
	/*private double[] invaderPos = { 48, 48, 106, 48, 164, 48, 212, 28, 270, 48, 328, 48,
									48, 106, 106, 106, 164, 106, 212, 106, 270, 106, 328, 106,
									48, 164, 106, 164, 164, 164, 212, 164, 270, 164, 328, 164,
									48, 212, 106, 212, 164, 212, 212, 212, 270, 212, 328, 212,
									48, 270, 106, 270, 164, 270, 212, 270, 270, 270, 328, 270,
									48, 328, 106, 328, 164, 328, 212, 328, 270, 328, 328, 328};*/
									
	private double[] invaderPos = { 50, 50, 50, 100, 50, 150, 50, 200, 50, 250 };

	private double[] bunkerPos = { 0, 0, 70, 0, 140, 0, 210, 0 };

	public Game() {
		StdDraw.setScale(0, 512);
		gameFrame = new Rectangle(256, 256, 540, 540);
		
		// Hero initialized
		{
			hero = new Hero(256.0, HeroShot);
			lives = INIT_LIVES;
			HeroShot = new Shot(-1, -1, 1, false);
			heroExplosion = new Explosion(0, 1, 1);
		}
		
		// Invaders initialized
		{
		
			invaders = new Invader[INIT_INVADERS];
			for (int i = 0; i < invaders.length; i++) {
					if(i < 10) {
					invaders[i] = new Invader(0 + 20*i, 500, EvilBomb);
					}
					else if(i >= 10 && i < 20) {
					invaders[i] = new Invader(-200 + 20*i, 480, EvilBomb);
					}
					else if(i >= 20 && i < 30) {
					invaders[i] = new Invader(-400 + 20*i, 460, EvilBomb);
					}
					else if(i >= 30 && i <= 40) {
					invaders[i] = new Invader(-600 + 20*i, 440, EvilBomb);
					}
			}
			
			EvilBomb = new Shot(-1, -1, -1, false);
			invExplosion = new Explosion(0, 1, 1);
		}
		
		// Bunkers initialized
		{
			bunkers = new Bunker[INIT_BUNKERS];
			for (int i = 0; i < bunkers.length; i++) {
				bunkers[i] = new Bunker(20 + i*24, 20);
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
				if(invaders[i].getX() > 512) { 
					Dx = -Dx;
					//Dx = (Dx > 0) ? (-1 * Dx) + 1 : (-1 * Dx) - 1;
					Dy = !Dy;
					break;
				}
				/*if (!gameFrame.contains(invaders[i].getBounds())) {
					Dx = (Dx > 0) ? (-1 * Dx) + 1 : (-1 * Dx) - 1;
					Dy = !Dy;
					break;
				} else {
					Dy = false;
				}*/
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
		StdDraw.clear(Color.BLACK);
		Color color = new Color(255, 255, 100);
		
		color = new Color(counter, counter, counter);
		
		counter = (counter + 2) % 255;
		
			StdDraw.setPenColor(color);
			StdDraw.filledRectangle(256,256,100,100);
		
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
		final double ns = (1000000000.0 /30);
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
			if (delta >= 1) {
				update();
				delta--;
				updates++;
				render();
			}
			
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


	
}
public class Game
{
	// Dx stjórnar hraða og stefnu óvinanna.
	private int Dx = 1;
	
	
	//Fjöldi invadera
	private static final int ARMY = 32;
	private static final int COVER = 5;
	
	//Shot 
	public Shot HeroShot;
	public Shot EvilBomb;
	
	private boolean running = true;
	
	public Hero hero;
	
	public Rectangle GameFrame(double x0, double y0, double w, double h) {
		x0 = 256;
		xy = 256;
		w = 512;
		h = 512;
	}
	
	public Game() {
		HeroShot = new Shot();
		EvilBomb = new Bomb();
		hero = new Hero();
		
		HeroShot = new Shot(-1, -1, -1, false);
		
		Invader[] invaders = new Invader[ARMY];
		Bunker[] bunkers = new Bunker[COVER];
	}
	
	// Uppfærir stöðu allra hluta í leiknum
	
	public void update() {
		HeroShot.update();
		EvilBomb.update();
		hero.update();
		for (int i = 0; i < invaders.length; i++) {
			invaders[i].update();
		}
		for(int i = 0; i < bunkers.length; i++) {
			bunkers[i].update();
		}
	}
	
	/*
	 * Hreinsar skjáinn fyrst, kallar svo á allar
	 * render() aðferðir hjá öllum hlutum sem á að
	 * teikna á skjáinn.
	 */
	public void render()
	{
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
	
	public int getDx()
		{	return Dx;	}
	
	public void setDx(int Dx)
		{	this.Dx = Dx;	}

	
}
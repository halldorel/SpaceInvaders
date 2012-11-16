import java.awt.Color;

public class explosionTest
{

	private static Explosion a, b, c, d;
	
	public static void main(String[] args)
	{
		
		StdDraw.clear(Color.BLACK);
		a = new Explosion(20, 256.0, 256.0);
		
		StdDraw.setScale(0.0, 512.0);
		long startTime = System.currentTimeMillis();
		
		long lastTime = System.nanoTime();		
		final double ns = (1000000000.0 /60);
		double delta = 0;		

		for (;;)
		{

			if (System.currentTimeMillis() - startTime > 2000) {
				a = new Explosion(20, 256.0, 256.0);
				startTime = System.currentTimeMillis();
			}
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				a.update(true);
				delta--;
			}
			StdDraw.clear(Color.BLACK);
			a.render();
		}
	}
	
}
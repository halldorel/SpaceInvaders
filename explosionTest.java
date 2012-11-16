import java.awt.Color;

public class explosionTest
{

	private static Explosion a, b, c, d;
	
	public static void main(String[] args)
	{
		
		
		a = new Explosion(20, 200.0, 200.0);
		
		StdDraw.setScale(0.0, 512.0);
		long startTime = System.currentTimeMillis();
		
		for (;;)
		{
			StdDraw.clear(Color.BLACK);
			if (System.currentTimeMillis() - startTime > 2000) {
				a = new Explosion(20, 200.0, 200.0);
				startTime = System.currentTimeMillis();
			}
			
			a.update();
			a.render();
		}
	}
	
}
		
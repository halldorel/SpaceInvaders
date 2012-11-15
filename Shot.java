public class Shot //extends Rectangle
{
	// X position of shooter
	private final double xpos;
	private double ypos;
	
	// 
	private final static double INIT_YPOS = 1.0;
	private final static double SIZE = 4;
	private final static double SPEED = 4;
	
	// Rectangle object
	private Rectangle shot;
	
	// Has the shot exited the screen?
	private boolean alive;
	
	// Speed constant
	// public static speed = 0.1;
	
	// AÐLAGA SHOT.JAVA SVO HANN ERFI FRÁ RECTANGLE
	
	public Shot(double xpos, int direction)
	{
		this.xpos = xpos;
		this.ypos = INIT_YPOS;
		this.shot = new Rectangle(this.xpos, INIT_YPOS, SIZE, SIZE);
		this.alive = true;
	}
	
	public void update()
	{
		if(alive)
		{
			// 
			this.shot.setY(this.shot.getY() + SPEED);
		}
	}
	
	public void kill()
	{
		this.alive = false;
	}
	
	public void draw()
	{
		if(this.alive == true)
		{
			shot.draw();
		}
	}
	
	
	// Testing
	public void testDraw()
	{
		StdDraw.setXscale(0, 512);
		StdDraw.setYscale(0, 512);
		
		draw();
		
		String status = "Y = " + this.shot.getY();
		StdDraw.clear();
		//StdDraw.text(3, 3, status);
	}
	
	// Test client
	public static void main(String[] args)
	{
		Shot s = new Shot(256, 10);
		while(true)
		{
			s.update();
			s.testDraw();
		}
	}
}
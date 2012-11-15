public class Shot
{
	// (x, y) miðpunktur skotsins
	private final double x;
	private double y;
	
	private final static double INIT_YPOS = 1.0;
	private final static double SIZE = 4.0;
	private final static double SPEED = 4.0;
	
	// Rectangle hlutur fyrir skotið
	private Rectangle shot;
	
	// Er skotið innan skjáramma?
	private boolean alive;
	
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
			// Rectangle show
			shot.show();
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
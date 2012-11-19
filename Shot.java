public class Shot
{
	// (x, y) miðpunktur skotsins
	private final double x;
	private double y;
	
	private static final int WIDTH = 4;
	private static final int HEIGHT = 4;
	private static final boolean ALIVE = true;
	private static final boolean DEAD = false;
	
	//Direction > 0 ef um Hero er að ræða, < 0 ef um invader er að ræða
	private int direction;
	
	private final static double INIT_YPOS = 1.0;
	private final static double SIZE = 4.0;
	private final static double SPEED = 4.0;
	
	// Rectangle hlutur fyrir skotið
	private Rectangle bounds;
	
	// Er skotið innan skjáramma?
	private boolean status;
	
	public Shot(double x, double y, int direction, boolean status) {
		this.x = x;
		this.y = INIT_YPOS;
		this.status = status;
		this.direction = direction;
		//bounds = new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public void update() {
		if(status) {
			if(direction > 0) bounds.setY(this.bounds.getY() + SPEED);
			else bounds.setY(this.bounds.getY() - SPEED);
			
		}
	}
	
	public Rectangle getBounds() {
		bounds = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		return bounds;
	}
	
	public void kill() {
		this.status = false;
	}
	
	public void draw() {
		if(this.status) {
			bounds.show();
		}
	}
}
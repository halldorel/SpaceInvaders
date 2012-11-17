/*
 * Klasi fyrir byrgi sem leikmaður getur falið sig bak við.
 * Hvert byrgi er samsett úr fimm Brick hlutum sem hver um 
 * sig hefur þrjú líf og mismunandi útlit fyrir hvert stig
 * af skaða.
 */

public class Bunker
{
	private static final int NUMBER_OF_BRICKS = 5;
	
	private double x, y;
	private Brick[] bricks;
	
	public Bunker(double x, double y)
	{
		this.x = x;
		this.y = y;
		
		bricks = new Brick[NUMBER_OF_BRICKS];
		
		// Init fyrir brick fylki: býr til lögunina á bunker
		// m.t.t upphafshnita x og y.
		{
			bricks[0] = new Brick(x + Brick.RADIUS, y + Brick.RADIUS);
			bricks[1] = new Brick(x + 3*Brick.RADIUS, y + 2*Brick.RADIUS);
			bricks[2] = new Brick(x + 5*Brick.RADIUS, y + 2*Brick.RADIUS);
			bricks[3] = new Brick(x + 7*Brick.RADIUS, y + 2*Brick.RADIUS);
			bricks[4] = new Brick(x + 9*Brick.RADIUS, y + Brick.RADIUS);
		}
		
	}
	
	public void update()
	{
		for (int i = 0; i < bricks.length; i++)
			{	bricks[i].update();		}
	}
	
	public void render()
	{
		for (int i = 0; i < bricks.length; i++)
			{	bricks[i].render();	}
	}
	
}
public abstract class Collider
{
	public boolean checkCollision(Collider that) {
		Rectangle r = this.getBounds();
		return r.intersects(that.getBounds());
	}
	
	public abstract Rectangle getBounds()
}
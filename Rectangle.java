public class Rectangle {
	// Tilviksbreytur
	// width, height >= 0, (x, y) eru miðhnit Rectangle
	private double x;
	private double y;
	private final double width;
	private final double height;
	
	public Rectangle(double x0, double y0, double w, double h) {
		x = x0;
		y = y0;
		width = w;
		height = h;
	}
	
	// Notkun: c = a.area();
	// Fyrir: ekkert
	// Eftir: c er flatarmál a
	public double area() {
		double area = width * height;
		return area;
	}
	
	// Notkun: c = a.perimeter();
	// Fyrir: ekkert
	// Eftir: c er ummál a
	public double perimeter() {
		double perimeter = 2 * (width + height);
		return perimeter;
	}
	
	// Notkun: c = a.intersects(b);
	// Fyrir: ekkert
	// Eftir: c er true ef a sker b, annars false
	public boolean intersects(Rectangle b) {
		Interval bottomA = new Interval(this.x - (this.width)/2.0, this.x + (this.width)/2.0);
		Interval bottomB = new Interval(b.x - (b.x)/2, b.x + (b.x)/2);
		Interval sideA = new Interval(this.y - (this.height)/2.0, this.y + (this.height)/2.0);
		Interval sideB = new Interval(b.y - (b.y)/2, b.y + (b.y)/2);
		if(bottomA.intersects(bottomB) && sideA.intersects(sideB)) {
			if(this.contains(b)) return false;
			else return true;
		}
		else return false;
	}
	
	// Notkun: c = a.contains(b);
	// Fyrir: ekkert
	// Eftir: c er true ef b er alfarið inni í b, annars false
	public boolean contains(Rectangle b) {
		Interval bottomA = new Interval(this.x - (this.width)/2.0 + (b.width)/2, this.x + (this.width)/2.0 - (b.width)/2);
		Interval sideA = new Interval(this.y - (this.height)/2.0 + (b.height)/2, this.y + (this.height)/2.0 - (b.height)/2);
		if(bottomA.contains((b.x)) && sideA.contains((b.y))) return true;
		else return false;
	}
	
	// Notkun: x = getX();
	// Eftir: skilar x-hniti
	public double getX()
	{
		return this.x;
	}
	
	// Notkun: y = getY();
	// Eftir: skilar x-hniti
	public double getY()
	{
		return this.y;
	}
	
	// Notkun: setX(x);
	// Fyrir: x er nýtt x hnit Rectangle hlutsins
	// Eftir: this.x tekur gildið x
	public void setX(double x)
	{
		this.x = x;
	}
	
	// Notkun: setY(y);
	// Fyrir: y er nýtt y hnit Rectangle hlutsins
	// Eftir: this.y tekur gildið y
	public void setY(double y)
	{
		this.y = y;	
	}
	
	// Notkun: a.show();
	// Fyrir: ekkert
	// Eftir: ekkert, hliðarverkun: teiknar a á skjá
	public void show() {
		StdDraw.rectangle(x, y, width/2.0, height/2.0);
	}
}
public class Interval {
	private final double l, r;
	
	public Interval(double left, double right) {
		l = left;
		r = right;
	}
	
	//Notkun: c = I.contains(x);
	//Fyrir: I er bil;
	//Eftir: c er true ef x er á I
	public boolean contains(double x) {
		if(x >= this.l && x <= this.r) return true;
		else return false;
	}

	//Notkun: d = a.intersects(b);
	//Fyrir: a og b eru bil;
	//Eftir: c er true ef b og a skarast;
	public boolean intersects(Interval b) {
		if(b.contains(this.l) || b.contains(this.r) || this.contains(b.l)) return true;
		else return false;
	}
	
	//Notkun: s = a.toString();
	//Fyrir: a er bil;
	//Eftir: s strengjaframsetnings bilsins a
	public String toString() {
		return "[" + l + ";" + r + "]";
	}
}
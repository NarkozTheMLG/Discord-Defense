package GameSystem;

public class TypeB extends Enemy{
	public TypeB(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private double distance;

    public double getDistance() {
        return this.distance;
    }
    
    public void setDistance(double distance) {
        this.distance = distance;
    }
}

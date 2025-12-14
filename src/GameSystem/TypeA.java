package GameSystem;
import java.awt.geom.Point2D;

public class TypeA extends Enemy {
	public TypeA(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private double distanceA;

    public double getDistance() {
        return this.distanceA;
    }
    
    public void setDistance(double distance) {
        this.distanceA = distance;
    }

	@Override
	public boolean isShot() {
		return true;
	}

	@Override
	public double findDistance(Character d1, Character d2) {
		//double distance = Point2D.distance(x1, y1, x2, y2);
		//return distance;
		return 0;
	}


}

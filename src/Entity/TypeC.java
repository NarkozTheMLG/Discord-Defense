package Entity;
import ui_items.Lanes;

public class TypeC extends Enemy {
	
	double speed = 1.0; //slow
	String laneChangeRate = "high"; //High
	int curLane = (int)(Math.random()* Lanes.laneCount);
	
	public TypeC(double x, double y, double speed, String laneChangeRate, int curLane) {
		super(x, y, speed, laneChangeRate, curLane);
	}	
	
	@Override
	public void attack() {
	}

	@Override
    public void update() {
        this.x -= speed; //move left by each frame
        changeLane(); //randomly change lanes
    }
}


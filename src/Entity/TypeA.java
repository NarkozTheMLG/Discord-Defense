package Entity;
import ui_items.Lanes;

public class TypeA extends Enemy {

	double speed = 5.0; // Fast
	String laneChangeRate = "low"; // Rare
	int curLane = (int)(Math.random()* Lanes.laneCount);
	
	public TypeA(double x, double y, double speed, String laneChangeRate, int curLane) {
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

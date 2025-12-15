package Entity;
import ui_items.Lanes;

public class TypeB extends Enemy {
	
	double speed = 2.5; //Medium
	String laneChangeRate = "medium"; //Medium
	int curLane = (int)(Math.random()* Lanes.laneCount);
	
	public TypeB(double x, double y, double speed, String laneChangeRate, int curLane) {
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


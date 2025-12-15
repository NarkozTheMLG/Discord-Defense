package Entity;
import java.awt.image.BufferedImage;

import ui_items.Lanes;

public class TypeB extends Enemy {
	
	//TYPE B: Medium speed, Medium lane change
	public TypeB(double x, double y, double speed, String laneChangeRate, int curLane, BufferedImage sprite) {
		super(x, y, speed, laneChangeRate, curLane, sprite);
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


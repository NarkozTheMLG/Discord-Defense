package Entity;
import java.awt.image.BufferedImage;

import ui_items.Lanes;

public class TypeA extends Enemy {
	
	//TYPE A: high speed, low lane change	
	//Drum Enemy
	public TypeA(double x, double y, double speed, String laneChangeRate, int curLane, BufferedImage sheet) {
		super(x, y, speed, laneChangeRate, curLane, sheet, 4);
	}	

	@Override
	public void attack() {
		
	}

	@Override
    public void update() {
        this.x -= speed; //move left by each frame
        cycleSubSheets(); //update aniTick (timer)
        changeLane(); //randomly change lanes
    }
}

package Entity;
import java.util.ArrayList;

import ui_items.EnergyBar;

public class Piano extends Character{

	private static PianoKey[] keys;
	public ArrayList<Bullet> shot = new ArrayList<>();
	
	public Piano(double x, double y) {
        super(x, y, 100, 300); //for now
        this.hp = 100; //for now
	}
	
	public PianoKey getSpecificKey(int index) {
        if (index >= 0 && index < keys.length) { //verify range
            return keys[index];
        } else {
        	System.out.println("invalid index.");
            return null;
        }
    }

	@Override
	public void update() {}
	
	public void fire(int laneIndex) {
		if(EnergyBar.curEnergy > 0) {
			double laneY = laneIndex * 100;
			shot.add(new Bullet(this.x + 50, laneY));
			//if it = 0 let 1s delay happen when user wants to shoot so I wrote <0 not <=0
			if(!(EnergyBar.curEnergy < 0)) 
				EnergyBar.curEnergy--;
		}
	}

}




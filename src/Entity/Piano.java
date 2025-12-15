package Entity;
import java.util.ArrayList;

import GameSystem.Main;
import ui_items.EnergyBar;

public class Piano extends Character{

	private static PianoKey[] keys;
	public static ArrayList<Bullet> shot = new ArrayList<>();
	
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
	public void update() {
		for (int i = 0; i < shot.size(); i++) {
	        Bullet b = shot.get(i);
	        if(b.isDead()) {
	        	shot.remove(i);
	        	i--;
	        }
	        else {
	        	  b.update();
	  	        if (b.getX() > Main.WIDTH) //if one shot goes beyond screen it dies
	  	            shot.remove(i);
	  	      i--;
	        }
	        
		}
	}
	public void fire(int laneIndex) {
		if(EnergyBar.curEnergy > 0) {
			double laneY = laneIndex * 100;
			shot.add(new Bullet(this.x + 50, laneY));
			//if it = 0 let 1s delay happen when user wants to shoot so I wrote <0 not <=0
			if(!(EnergyBar.curEnergy < 0)) 
				EnergyBar.curEnergy--;
		}
	}

	public int getPianoHp() {
		return this.hp;
	}
	public void setPianoHp(int value) {
		this.hp = value;
	}
}




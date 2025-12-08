package GameSystem;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Enemy extends Character implements EnemyInterface{

	protected double speed;
    protected String usedItem;
    protected int currLane;
    protected String laneChangeRate; 
    protected BufferedImage sprite;
    protected ArrayList<Enemy> enemyList;
	
	public Enemy() {
		this.enemyList = new ArrayList<>();
	}
	
	public void moveTo(double x, double y) {
        System.out.println("Moving to coordinates: " + x + ", " + y);
    }
	
	public boolean isAlive() {
        // Placeholder logic
        return true;
	}
	
	public void update() {
       
    }
	
	public double findDistance(double d) {
        return d; 
    }
	
	public void affectEnemy(String item) {
        System.out.println("Enemy affected by item: " + item);
        this.usedItem = item;
	}
	
	public void respawn() {
        System.out.println("Enemy respawned.");
    }
	@Override
	public void takeDamage() {
		
	}
	
	@Override
	public void attack() {
		System.out.println("Enemy is attacking!");
	}

}

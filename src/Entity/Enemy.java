package Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ui_items.Lanes;

public abstract class Enemy extends Character implements EnemyInterface{

	
	protected double speed;
    protected String laneChangeRate; // Low, Medium, High
    protected int curLane;
    protected int hp;
    protected BufferedImage sprite;
    protected static ArrayList<Enemy> enemyList = new ArrayList<>();
    
    
    public Enemy(double x, double y, double speed, String laneChangeRate, int curLane, BufferedImage sprite) {
		super(x, y, 50, 50);
		this.speed = speed;
		this.laneChangeRate = laneChangeRate;
		this.curLane = curLane;
		this.hp = 3; //all enemies have 3 hp
		this.sprite = sprite;
		enemyList.add(this);
	}
       
    public void changeLane() {
    	double chance = 0;
    	
    	if(laneChangeRate.equalsIgnoreCase("low"))
    		chance = 0.001;
    	else if(laneChangeRate.equalsIgnoreCase("medium"))
    		chance = 0.004;
    	else if(laneChangeRate.equalsIgnoreCase("high"))
    		chance = 0.006;
    	else 
    		System.out.println("invalid laneChangeRate.");
    	
    	if (Math.random() < chance) 
    		move();
    }
    
    public void move() {
    	boolean up = false;
    	if(Math.random() > 0.5)
    		up = true;
    	
    	if(up) {
    		if(curLane >= 0) { 
    			this.y += Lanes.laneHeight; //go up
    			System.out.println("moving 1 lane up, new lane: " + ++curLane);
    		}
    	}
    	else {
    		if(curLane <= (Lanes.laneCount - 1)) {
    			this.y -= Lanes.laneHeight; //go down
    			System.out.println("moving 1 lane down, new lane: " + --curLane);
    		}
    	}
    }

}

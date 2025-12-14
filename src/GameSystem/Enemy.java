package GameSystem;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Enemy extends Character implements EnemyInterface{

	public Enemy(double x, double y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	protected double speed;
    protected String usedItem;
    protected String laneChangeRate; 
    protected BufferedImage sprite;
    protected static ArrayList<Enemy> enemyList = new ArrayList<>();
    


}

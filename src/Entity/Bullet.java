package Entity;
import java.awt.Rectangle;
public class Bullet extends Character{
	private final int bulletspeed = 10;
	public static double bulletSpeedMultiplayer = 1;
	public Bullet(double x, double y) {
	    super(x, y, 20, 20); 
	    this.hp = 1; //dies if touches sth immediately
	}

	@Override
	public void update() {
		this.x += bulletspeed * bulletSpeedMultiplayer;
	}
	
	public int getBulletHp() {
		return this.hp;
	}
	
	public void setBulletHp(int value) {
		this.hp = value;
	}
}

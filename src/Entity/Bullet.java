package Entity;
import java.awt.Rectangle;
public class Bullet extends Character{

	public Bullet(double x, double y) {
	    super(x, y, 20, 20); 
	    this.hp = 1; //dies if touches sth immediately
	}

	@Override
	public void update() {
		this.x += 10;
	}
	
	public int getBulletHp() {
		return this.hp;
	}
	
	public void setBulletHp(int value) {
		this.hp = value;
	}
}

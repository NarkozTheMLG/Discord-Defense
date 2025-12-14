package GameSystem;
import java.awt.Rectangle;
public class Bullet extends Character{

	public Bullet(double x, double y) {
	    super(x, y, 20, 20); 
	    this.hp = 1; 
	}

	@Override
	public void update() {
		this.x += 10;
	}
}

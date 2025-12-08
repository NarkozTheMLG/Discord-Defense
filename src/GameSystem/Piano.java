package GameSystem;

public class Piano extends Character{

	private static Piano[] keys = new Piano[8];
	private double shootSpeed; 
	
	public Piano() {
		
	}
	
	public Piano getKey(int index) {
		Piano p = keys[0];
		return p;
	}
	
	public boolean isShot() {
		return true;
	}
	
	@Override
	public void takeDamage() {
		
	}

}

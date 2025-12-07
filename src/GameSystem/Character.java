package GameSystem;

public abstract class Character {

	protected double damage;
	protected double hp;
	
	Character(){
		
	}
	
	public abstract void takeDamage();
}


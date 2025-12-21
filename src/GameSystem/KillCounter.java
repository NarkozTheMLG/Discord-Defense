package GameSystem;

import java.util.HashMap;

public class KillCounter {

	// Declare
	public static HashMap<String, Integer> counts;

	// Constructor
	public KillCounter() {
		counts = new HashMap<>();
		counts.put("TypeA", 0);
		counts.put("TypeB", 0);
		counts.put("TypeC", 0);
	}

	// methods
	public void addKill(String enemyType) {
		// Get current count, default 0 just in case
		int current = counts.getOrDefault(enemyType, 0);

		// increment kill
		counts.put(enemyType, current + 1);
		System.out.println("Kill for: " + enemyType + " | Total kill: " + (current + 1));
	}

	public static int getSpecificTypeKillCount(String enemyType) {
		return counts.getOrDefault(enemyType, 0);
	}

	public void printAllStats() { // for debug purpose
		for (String key : counts.keySet()) {
			System.out.println(key + ": " + counts.get(key));
			// TypeA: 10
		}
	}
}

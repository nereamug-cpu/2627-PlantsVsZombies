package pvz.logic.gameobjects.factories;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ZombieFactory {
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		// ...
	);
	
	public static Zombie spawnZombie(String zombieName, GameWorld game, Position position) {
		// ...
	}
	
	public static List<Zombie> getAvailabkeZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	// ...
}

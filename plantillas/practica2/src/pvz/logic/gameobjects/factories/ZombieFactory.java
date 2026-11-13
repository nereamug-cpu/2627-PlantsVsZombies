package pvz.logic.gameobjects.factories;
import pvz.logic.gameobjects.*;
import utils.*;
import pvz.logic.GameWorld;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ZombieFactory {
	private static final List<Zombies> AVAILABLE_ZOMBIES = Arrays.asList(
		// ...
	);
	
	public static Zombies spawnZombie(String zombieName, GameWorld game, Position position) {
		// ...
	}
	
	public static List<Zombies> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	// ...
}

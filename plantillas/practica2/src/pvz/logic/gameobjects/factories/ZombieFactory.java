package pvz.logic.gameobjects.factories;

import java.util.Arrays;
import pvz.logic.gameobjects.*;
import pvz.logic.*;
import pvz.utils.*;
import java.util.List;
import java.util.Collections;

public class ZombieFactory {
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		// ...
	);
	
	public static Zombie spawnZombie(String zombieName, GameWorld game, Position position) {
		Zombie z = null;
		boolean found = false;
		int pos = 0;
		
		while (!found && pos < AVAILABLE_ZOMBIES.size()) {
			z = AVAILABLE_ZOMBIES.get(pos);
			if (z.verifyName(zombieName)) {
				found = true;
			}
			else {
				pos++;
			}
		}
		
		return z.add(game, position);
	}
	
	public static List<Zombie> getAvailabkeZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	// ...
}

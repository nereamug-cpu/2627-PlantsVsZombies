package pvz.logic.gameobjects.factories;
import pvz.logic.gameobjects.*;
import utils.*;
import pvz.logic.GameWorld;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ZombieFactory {
	private static final List<Zombies> AVAILABLE_ZOMBIES = Arrays.asList(
		new Zombie(),
		new BucketHead(),
		new SportyZombie(),
		new ExplosiveZombie()
	);
	
	public static Zombies spawnZombie(String zombieName, GameWorld game, Position position) {
		boolean found = false;
		int pos = 0;
		Zombies zombie = null;
		
		while (!found && pos < AVAILABLE_ZOMBIES.size()) {
			zombie = AVAILABLE_ZOMBIES.get(pos);
			
			if (zombie.getName().equalsIgnoreCase(zombieName) || zombie.getSymbol().equalsIgnoreCase(zombieName)) {
				found = true;
			}
			pos++;
		}
		
		if (!found) {
			zombie = null;
		}
		else {
			zombie = zombie.copy(position, game);
		}
		
		return zombie;
	}
	
	public static List<Zombies> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	public static boolean validZombieName(String zombieName) {
		if (zombieName == null) {
			return false;
		}
		
		Zombies zombie = null;
		int pos = 0;
		boolean found = false;
		
		while (!found && pos < AVAILABLE_ZOMBIES.size()) {
			zombie = AVAILABLE_ZOMBIES.get(pos);
			if (zombie.getName().equalsIgnoreCase(zombieName) || zombie.getSymbol().equalsIgnoreCase(zombieName)) {
				found = true;
			}
			pos++;
		}
		
		return found;
	}
}
